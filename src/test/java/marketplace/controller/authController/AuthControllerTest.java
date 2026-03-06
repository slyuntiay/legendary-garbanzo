package marketplace.controller.authController;

import lombok.NoArgsConstructor;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.entity.Customer;
import marketplace.entity.User;
import marketplace.mapper.CustomerMapper;
import marketplace.mapper.UserMapper;
import marketplace.service.JwtTokenService.JwtTokenService;
import marketplace.service.userService.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenService jwtTokenService;

    @InjectMocks
    private AuthController authController;

    @Test
    void register_ReturnsCustomerResponse() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("username");
        request.setPassword("password");

        User user = new User();
        Customer customer = new Customer();
        Customer savedCustomer = new Customer();
        CustomerResponse customerResponse = new CustomerResponse();

        when(userMapper.toEntity(any(UserRegisterRequest.class))).thenReturn(user);
        when(passwordEncoder.encode(any(String.class))).thenReturn("encoded");
        when(userService.save(any(User.class))).thenReturn(user);
        when(customerMapper.toEntity(any(UserRegisterRequest.class))).thenReturn(customer);
        when(userService.save(any(Customer.class))).thenReturn(savedCustomer);
        when(customerMapper.toResponse(any(Customer.class))).thenReturn(customerResponse);

        ResponseEntity<CustomerResponse> response = authController.register(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customerResponse, response.getBody());
        assertNotNull(response.getBody());

        verify(userMapper).toEntity(any(UserRegisterRequest.class));
        verify(passwordEncoder).encode(any(String.class));
        verify(userService).save(any(User.class));
        verify(customerMapper).toEntity(any(UserRegisterRequest.class));
        verify(userService).save(any(Customer.class));
        verify(customerMapper).toResponse(any(Customer.class));
    }
}

