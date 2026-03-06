package marketplace.service.userService;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Customer;
import marketplace.entity.User;
import marketplace.repository.customer.CustomerRepo;
import marketplace.repository.user.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    @Transactional
    public User save(User user) {
        return userRepo.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}

