package marketplace.controller.basketController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.dto.basketDto.CreateBasketResponseDto;
import marketplace.entity.Basket;
import marketplace.service.basketService.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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

    @GetMapping(path = "/read/{id}")
    public ResponseEntity<CreateBasketResponseDto> read(
            @PathVariable int id) {
        try {
            Basket basket = basketService.read(id);
            return ResponseEntity.ok(new CreateBasketResponseDto(basket));
        } catch (NoSuchElementException e){
           return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/update/{clientId}/{productId}")
    public ResponseEntity<CreateBasketResponseDto> update(
            @PathVariable int clientId, @PathVariable int productId,
            @RequestBody CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = basketService.update(clientId, productId, createBasketRequestDto);
        CreateBasketResponseDto responseDto = new CreateBasketResponseDto(basket);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<CreateBasketResponseDto> delete(@PathVariable int id) {
        Basket basket = basketService.read(id);
        basketService.delete(id);
        CreateBasketResponseDto responseDto = new CreateBasketResponseDto(basket);
        return ResponseEntity.ok(responseDto);
    }
    @DeleteMapping(path = "/deleteProduct/{clientId}/{productId}")
    public ResponseEntity<CreateBasketResponseDto> deleteProduct(@PathVariable int clientId, @PathVariable int productId) {
        Basket basket = basketService.read(clientId);
        basketService.deleteProduct(clientId,productId);
        CreateBasketResponseDto responseDto = new CreateBasketResponseDto(basket);
        return ResponseEntity.ok(responseDto);
    }
}

