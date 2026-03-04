package marketplace.service.userService;
import lombok.RequiredArgsConstructor;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.dto.userDto.UserProfileResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.entity.Customer;
import marketplace.entity.User;
import marketplace.mapper.CustomerMapper;
import marketplace.mapper.UserMapper;
import marketplace.repository.customer.CustomerRepo;
import marketplace.repository.user.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserMapper userMapper;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final CustomerRepo customerRepo;

    @Transactional
    public CustomerResponse register(UserRegisterRequest request) {

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        userRepo.save(user);

        Customer customer = customerMapper.toEntity(request);
        customer.setUser(user);
        customerRepo.save(customer);

        return customerMapper.toResponse(customer);
    }


    public UserProfileResponse getProfile(String username) {
        User user = userRepo.findByUsername(username).orElseThrow();
        return userMapper.toResponse(user);  // 1 строка!
    }

    public void updateProfile(UserRegisterRequest request, User user) {
        userMapper.updateFromDto(request, user);  // 1 строка!
    }
}

