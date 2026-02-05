package marketplace.controller.productContoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.clientDto.ClientResponseDto;
import org.slf4j.Logger;
import marketplace.dto.productDto.ProductRequestDto;
import marketplace.dto.productDto.ProductResponseDto;
import marketplace.entity.Product;
import marketplace.service.productService.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(path = "/save")
    public ResponseEntity<ProductResponseDto> save(
            @RequestBody ProductRequestDto productRequestDto) {
        log.info("SAVE product: name={}, price={}, quantity={}",
                productRequestDto.getName(), productRequestDto.getPrice(), productRequestDto.getQuantity());
        Product product = productService.save(productRequestDto);
        ProductResponseDto responseDto = new ProductResponseDto(product);
        log.info("SAVE OK: productId={}", product.getId());
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ProductResponseDto> find(@PathVariable int id) {
        log.info("FIND product by id={}", id);
        return productService.find(id)
                .map(product -> {
                    log.info("FIND OK: productId={}", product.getId());
                    return ResponseEntity.ok(new ProductResponseDto(product));
                })
                .orElseGet(() -> {
                    log.warn("FIND NOT FOUND: productId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PutMapping("/merge/{id}")
    public ResponseEntity<ProductResponseDto> update(
            @PathVariable int id,
            @Valid @RequestBody ProductRequestDto productRequestDto) {
        log.info("MERGE product: id={}, name={}, price={}, quantity={}",
                id, productRequestDto.getName(), productRequestDto.getPrice(), productRequestDto.getQuantity());

        return productService.merge(id, productRequestDto)
                .map(product -> {
                    log.info("MERGE OK: productId={}", product.getId());
                    return ResponseEntity.ok(new ProductResponseDto(product));
                })
                .orElseGet(() -> {
                    log.warn("MERGE NOT FOUND: productId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable int id) {
        log.info("REMOVE product by id={}", id);

        return productService.remove(id)
                .map(removed -> {
                    if (removed) {
                        log.info("REMOVE OK: productId={}", id);
                        return ResponseEntity.noContent().build();
                    } else {
                        log.warn("REMOVE NOT FOUND: productId={}", id);
                        return ResponseEntity.notFound().build();
                    }
                })
                .orElseGet(() -> {
                    log.warn("REMOVE NOT FOUND: productId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }
}