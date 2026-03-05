package marketplace.controller.testToken;

import lombok.RequiredArgsConstructor;
import marketplace.service.JwtTokenService.JwtTokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/token")
public class TestToken {
   private final JwtTokenService jwtTokenService;

    @GetMapping("/getToken")
    public String TestToken() {
        return jwtTokenService.generateToken("Иван","USER");
    }
}
