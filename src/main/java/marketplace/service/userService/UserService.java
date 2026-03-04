package marketplace.service.userService;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Customer;
import marketplace.entity.User;
import marketplace.repository.customer.CustomerRepo;
import marketplace.repository.user.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final CustomerRepo customerRepo;

    @Transactional
    public User save(User user) {
        return userRepo.save(user);
    }

    @Transactional
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }
}

