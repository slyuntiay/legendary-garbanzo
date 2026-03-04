package marketplace.controller.authController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.entity.Customer;
import marketplace.entity.User;
import marketplace.mapper.CustomerMapper;
import marketplace.mapper.UserMapper;
import marketplace.service.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Validated
@PreAuthorize("hasRole('ADMIN')")
public class AuthController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody UserRegisterRequest request) {

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        User savedUser = userService.save(user);

        Customer customer = customerMapper.toEntity(request);
        customer.setUser(savedUser);
        Customer savedCustomer = userService.save(customer);

        return ResponseEntity.ok(customerMapper.toResponse(savedCustomer));
    }
}

