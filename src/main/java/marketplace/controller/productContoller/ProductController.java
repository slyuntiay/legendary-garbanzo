package marketplace.controller.productContoller;

import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.CreateProductRequestDto;
import marketplace.dto.productDto.CreateProductResponseDto;
import marketplace.entity.Product;
import marketplace.service.productService.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateProductResponseDto> create(@RequestBody
                                                           CreateProductRequestDto createProductRequestDto) {
        Product product = productService.create(createProductRequestDto);
        CreateProductResponseDto responseDto = new CreateProductResponseDto(product);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<CreateProductResponseDto> delete(@PathVariable int id) {
        Product deletedProduct = productService.read(id);
        productService.delete(id);
        return ResponseEntity.ok(new CreateProductResponseDto(deletedProduct));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CreateProductResponseDto> update(
            @PathVariable int id,
            @RequestBody CreateProductRequestDto createProductRequestDto) {
        Product updatedProduct = productService.update(id, createProductRequestDto);
        CreateProductResponseDto responseDto = new CreateProductResponseDto(updatedProduct);

        return ResponseEntity.ok(responseDto);

    }

    @GetMapping(path = "/read/{id}")
    public ResponseEntity<CreateProductResponseDto> read(@PathVariable int id) {
        Product readProduct = productService.read(id);
        CreateProductResponseDto responseDto = new CreateProductResponseDto(readProduct);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/readAll")
    public ResponseEntity<List<CreateProductResponseDto>> readAll() {
        List<Product> products = productService.readAll();
        List<CreateProductResponseDto> responseDto = new ArrayList<>();
        for (Product product : products) {
            responseDto.add(new CreateProductResponseDto(product));
        }
        return ResponseEntity.ok(responseDto);
    }
}