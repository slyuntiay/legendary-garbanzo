package marketplace.controller.auth;

import lombok.RequiredArgsConstructor;
import marketplace.dto.customer.CustomerResponse;
import marketplace.dto.user.UserLoginRequest;
import marketplace.dto.user.UserRegisterRequest;
import marketplace.entity.Customer;
import marketplace.entity.User;
import marketplace.mapper.CustomerMapper;
import marketplace.mapper.UserMapper;
import marketplace.service.JwtToken.JwtTokenService;
import marketplace.service.customer.CustomerService;
import marketplace.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final UserService userService;
    private final CustomerService customerService;
    private final UserMapper userMapper;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody UserRegisterRequest request) {

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(User.Role.USER);
        User savedUser = userService.save(user);

        Customer customer = customerMapper.toEntity(request);
        customer.setUser(savedUser);
        Customer savedCustomer = customerService.save(customer);

        return ResponseEntity.ok(customerMapper.toResponse(savedCustomer));
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLoginRequest request) {

        User user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Неверный пароль");
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        String token = jwtTokenService.generateToken(user.getUsername(), user.getRole().name());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("username", user.getUsername());
        response.put("role", user.getRole().name());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/current-role")
    public ResponseEntity<Map<String, String>> getCurrentRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            throw new IllegalStateException("Пользователь не аутентифицирован");
        }

        String role = auth.getAuthorities().iterator().next().getAuthority();

        Map<String, String> response = new HashMap<>();
        response.put("role", role);

        return ResponseEntity.ok(response);
    }
}


