package marketplace.controller.productContoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.ClientRequestDto;
import marketplace.dto.clientDto.ClientResponseDto;
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
        Product product = productService.save(productRequestDto);
        ProductResponseDto responseDto = new ProductResponseDto(product);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ProductResponseDto> find(@PathVariable int id) {
        return productService.find(id)
                .map(product -> ResponseEntity.ok(new ProductResponseDto(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/merge/{id}")
    public ResponseEntity<ProductResponseDto> merge(
            @PathVariable int id,
            @Valid @RequestBody ProductRequestDto productRequestDto) {
        return productService.merge(id, productRequestDto)
                .map(product -> ResponseEntity.ok(new ProductResponseDto(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable int id) {productService.remove(id);
    }
}