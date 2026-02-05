package marketplace.controller.basketController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.dto.basketDto.BasketResponseDto;
import marketplace.entity.Basket;
import marketplace.service.basketService.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping(path = "/save")
    public ResponseEntity<BasketResponseDto> save(
            @RequestBody BasketRequestDto basketRequestDto) {
        log.info("SAVE basket: clientId={}, productId={}, quantity={}",
                basketRequestDto.getClientId(),
                basketRequestDto.getProductId(),
                basketRequestDto.getQuantity());

        Basket basket = basketService.save(basketRequestDto);
        BasketResponseDto responseDto = new BasketResponseDto(basket);
        log.info("SAVE OK: basketId={}", basket.getId());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<BasketResponseDto> find(@PathVariable int id) {
        log.info("FIND basket by id={}", id);

        return basketService.find(id)
                .map(basket -> {
                    log.info("FIND OK: basketId={}", basket.getId());
                    return ResponseEntity.ok(new BasketResponseDto(basket));
                })
                .orElseGet(() -> {
                    log.warn("FIND NOT FOUND: basketId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<BasketResponseDto> merge(
            @PathVariable int id,
            @RequestBody BasketRequestDto basketRequestDto) {
        log.info("MERGE basket id={}, clientId={}, productId={}, quantity={}",
                id,
                basketRequestDto.getClientId(),
                basketRequestDto.getProductId(),
                basketRequestDto.getQuantity());

        return basketService.merge(id, basketRequestDto)
                .map(basket -> {
                    log.info("MERGE OK: basketId={}", basket.getId());
                    return ResponseEntity.ok(new BasketResponseDto(basket));
                })
                .orElseGet(() -> {
                    log.warn("MERGE NOT FOUND: basketId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable int id) {
        log.info("REMOVE basket id={}", id);

        return basketService.remove(id)
                .map(deleted -> {
                    log.info("REMOVE OK: basketId={}", id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> {
                    log.warn("REMOVE NOT FOUND: basketId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }
}

