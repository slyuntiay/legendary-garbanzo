package marketplace.controller.productContoller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.ProductRequest;
import marketplace.mapper.ProductMapper;
import marketplace.dto.productDto.ProductResponse;
import marketplace.entity.Product;
import marketplace.service.productService.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Products")
@RequestMapping(path = "product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping(path = "/save")
    public ResponseEntity<ProductResponse> save(
            @RequestBody ProductRequest productRequest) {
        Product saved = productService.save(productMapper.toEntity(productRequest));
        ProductResponse responseDto = productMapper.toResponse(saved);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable long id) {
        return productService.find(id)
                .map(product -> ResponseEntity.ok(productMapper.toResponse(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<ProductResponse> merge(
            @PathVariable long id,
            @Valid @RequestBody ProductRequest productRequest) {
        return productService.merge(id, productMapper.toEntity(productRequest))
                .map(product -> {
                    productMapper.updateFromDto(productRequest, product);
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