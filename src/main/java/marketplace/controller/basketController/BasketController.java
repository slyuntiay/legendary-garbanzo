package marketplace.controller.basketController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.dto.basketDto.CreateBasketResponseDto;
import marketplace.entity.Basket;
import marketplace.service.basketService.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @GetMapping(path = "/read{id}")
    public ResponseEntity<CreateBasketResponseDto> read(
            @PathVariable int id){
        Optional<Basket> basket = basketService.read(id);
        CreateBasketResponseDto responseDto = new CreateBasketResponseDto(basket.orElse(null));
        return ResponseEntity.ok(responseDto);
    }
}

