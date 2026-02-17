package marketplace.controller.basketController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.dto.basketDto.BasketResponseDto;
import marketplace.dto.mapper.BasketMapper;
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
    private final BasketMapper basketMapper;

    @PostMapping(path = "/save")
    public ResponseEntity<BasketResponseDto> save(
            @RequestBody BasketRequestDto basketRequestDto) {
        Basket saved = basketService.save(basketMapper.toEntity(basketRequestDto));
        BasketResponseDto responseDto = basketMapper.toResponse(saved);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<BasketResponseDto> find(@PathVariable long id) {
        return basketService.find(id)
                .map(basket -> ResponseEntity.ok(basketMapper.toResponse(basket)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<BasketResponseDto> merge(
            @PathVariable long id,
            @RequestBody BasketRequestDto basketRequestDto) {
        return basketService.merge(id, basketMapper.toEntity(basketRequestDto))
                .map(basket -> {basketMapper.updateFromDto(basketRequestDto,basket);
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