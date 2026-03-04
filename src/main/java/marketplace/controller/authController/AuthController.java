package marketplace.controller.authController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.service.userService.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Validated

public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse register(@Valid @RequestBody UserRegisterRequest request) {
        CustomerResponse response = userService.register(request);
        return response;
    }
}


