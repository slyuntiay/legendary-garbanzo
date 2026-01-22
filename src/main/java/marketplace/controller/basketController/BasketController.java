package marketplace.controller.basketController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.dto.basketDto.CreateBasketResponseDto;
import marketplace.entity.Basket;
import marketplace.service.basketService.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CreateBasketResponseDto> update(
            @PathVariable int id,
            @RequestBody CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = basketService.update(id, createBasketRequestDto);
        CreateBasketResponseDto responseDto = new CreateBasketResponseDto(basket);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id) {
        basketService.delete(id);
    }

    @GetMapping(path = "readAll/{clientId}")
    public ResponseEntity<List<CreateBasketResponseDto>> readAll(
            @PathVariable int clientId) {
        try {
            List<Basket> baskets = basketService.readAll(clientId);
            List<CreateBasketResponseDto> responseDto = baskets.stream()
                    .map(CreateBasketResponseDto::new)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responseDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/deleteProduct/{clientId}")
    public void deleteProduct(@PathVariable int clientId) {
        basketService.deleteAll(clientId);
    }
}

