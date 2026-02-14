package marketplace.controller.productContoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.ProductRequestDto;
import marketplace.dto.productDto.ProductResponseDto;
import marketplace.entity.Product;
import marketplace.service.productService.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(path = "/save")
    public ResponseEntity<ProductResponseDto> save(
            @RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto responseDto = productService.save(productRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ProductResponseDto> find(@PathVariable long id) {
        return productService.find(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/merge/{id}")
    public ResponseEntity<ProductResponseDto> update(
            @PathVariable long id,
            @Valid @RequestBody ProductRequestDto productRequestDto) {
        return productService.merge(id, productRequestDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable long id) {
        return productService.remove(id)
                .map(deleted -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}