package marketplace.controller.productContoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.mapper.ProductMapper;
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
    private final ProductMapper productMapper;

    @PostMapping(path = "/save")
    public ResponseEntity<ProductResponseDto> save(
            @RequestBody ProductRequestDto productRequestDto) {
        Product saved = productService.save(productMapper.toEntity(productRequestDto));
        ProductResponseDto responseDto = productMapper.toResponse(saved);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ProductResponseDto> find(@PathVariable long id) {
        return productService.find(id)
                .map(product -> ResponseEntity.ok(productMapper.toResponse(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<ProductResponseDto> merge(
            @PathVariable long id,
            @Valid @RequestBody ProductRequestDto productRequestDto) {
        return productService.merge(id, productMapper.toEntity(productRequestDto))
                .map(product -> {
                    productMapper.updateFromDto(productRequestDto, product);
                    Product merged = productService.save(product);
                    return ResponseEntity.ok(productMapper.toResponse(merged));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable long id) {
        return productService.remove(id)
                .map(deleted -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}