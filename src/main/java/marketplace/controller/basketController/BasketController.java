package marketplace.controller.basketController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.basketDto.BasketRequest;
import marketplace.dto.basketDto.BasketResponse;
import marketplace.mapper.BasketMapper;
import marketplace.entity.Basket;
import marketplace.service.basketService.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "Baskets")
@RequestMapping(path = "basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    private final BasketMapper basketMapper;

    @PostMapping(path = "/save")
    public ResponseEntity<BasketResponse> save(
            @RequestBody BasketRequest basketRequest) {
        Basket saved = basketService.save(basketMapper.toEntity(basketRequest));
        BasketResponse responseDto = basketMapper.toResponse(saved);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<BasketResponse> find(@PathVariable long id) {
        return basketService.find(id)
                .map(basket -> ResponseEntity.ok(basketMapper.toResponse(basket)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<BasketResponse> merge(
            @PathVariable long id,
            @RequestBody BasketRequest basketRequest) {
        return basketService.merge(id, basketMapper.toEntity(basketRequest))
                .map(basket -> {basketMapper.updateFromDto(basketRequest,basket);
                    return ResponseEntity.ok(basketMapper.toResponse(basket));})
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable long id) {
        return basketService.remove(id)
                .map(deleted -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}