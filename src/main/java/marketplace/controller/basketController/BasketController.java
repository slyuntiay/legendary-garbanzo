package marketplace.controller.basketController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.dto.basketDto.BasketResponseDto;
import marketplace.entity.Basket;
import marketplace.service.basketService.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping(path = "basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping(path = "/save")
    public ResponseEntity<BasketResponseDto> save(
            @RequestBody BasketRequestDto basketRequestDto) {
        Basket basket = basketService.save(basketRequestDto);
        BasketResponseDto responseDto = new BasketResponseDto(basket);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<BasketResponseDto> find(@PathVariable int id) {
        log.info("Чтение корзины ID: {}", id);
        try {
            Basket basket = basketService.find(id);
            log.debug("Корзина {} найдена", id);
            return ResponseEntity.ok(new BasketResponseDto(basket));
        } catch (NoSuchElementException e) {
            log.warn("Корзина с ID {} не найдена", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<BasketResponseDto> merge(
            @PathVariable int id,
            @RequestBody BasketRequestDto basketRequestDto) {
        Basket basket = basketService.merge(id, basketRequestDto);
        BasketResponseDto responseDto = new BasketResponseDto(basket);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(path = "/remove/{id}")
    public void remove(@PathVariable int id) {
        basketService.remove(id);
    }
}

