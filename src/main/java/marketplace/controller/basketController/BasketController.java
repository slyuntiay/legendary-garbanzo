package marketplace.controller.basketController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.dto.basketDto.CreateBasketResponseDto;
import marketplace.dto.clientDto.CreateClientRequestDto;
import marketplace.dto.clientDto.CreateClientResponseDto;
import marketplace.entity.Basket;
import marketplace.entity.Client;
import marketplace.service.basketService.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateBasketResponseDto> create(
            @RequestBody CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = basketService.create(createBasketRequestDto);
        CreateBasketResponseDto responseDto = new CreateBasketResponseDto(basket);
        return ResponseEntity.ok(responseDto);
    }
}

