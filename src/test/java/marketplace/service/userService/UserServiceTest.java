package marketplace.service.userService;

import marketplace.entity.User;
import marketplace.repository.user.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepo userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void save_ShouldSaveUserToRepository() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("rawPassword");

        User savedUser = new User();
        when(userRepo.save(any(User.class))).thenReturn(savedUser);

        User result = userService.save(user);

        assertEquals(savedUser, result);
        verify(userRepo).save(argThat(u ->
                "test".equals(u.getUsername()) &&
                        "rawPassword".equals(u.getPassword())));
    }

    @Test
    void findByUsername_ShouldReturnUser() {
        User user = new User();
        when(userRepo.findByUsername("test")).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByUsername("test");

        assertTrue(result.isPresent());
        verify(userRepo).findByUsername("test");
    }
}
