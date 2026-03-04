package marketplace.controller.authController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.dto.userDto.UserLoginRequest;
import marketplace.dto.userDto.UserLoginResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.entity.Customer;
import marketplace.entity.User;
import marketplace.mapper.CustomerMapper;
import marketplace.mapper.UserMapper;
import marketplace.service.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
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
    private final UserMapper userMapper;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody UserRegisterRequest request) {

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(User.Role.ADMIN);
        user.setEnabled(true);
        User savedUser = userService.save(user);

        Customer customer = customerMapper.toEntity(request);
        customer.setUser(savedUser);
        Customer savedCustomer = userService.save(customer);

        return ResponseEntity.ok(customerMapper.toResponse(savedCustomer));
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLoginRequest request) {
        // 1. НАЙДИ ПОЛЬЗОВАТЕЛЯ
        User user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

        // 2. ПРОВЕРЬ ПАРОЛЬ
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Неверный пароль");
        }

        // 3. МАНУАЛЬНАЯ АУТЕНТИФИКАЦИЯ (БЕЗ AuthenticationManager!)
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        // 4. ОТВЕТ
        Map<String, Object> response = new HashMap<>();
        response.put("message", "✅ Логин успешен: " + user.getUsername());
        response.put("username", user.getUsername());
        response.put("role", user.getRole().name());

        return ResponseEntity.ok(response);
    }
}


