package marketplace.controller.productContoller;

import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.CreateProductRequestDto;
import marketplace.dto.productDto.CreateProductResponseDto;
import marketplace.entity.Product;
import marketplace.service.productService.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "products")
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

    @DeleteMapping(path = "/delete")
    public ResponseEntity<CreateProductResponseDto> delete(@PathVariable int id) {
        Product deletedProduct = productService.delete(id);
        CreateProductResponseDto responseDto = new CreateProductResponseDto(deletedProduct);
        return ResponseEntity.ok(responseDto);
    }
//    @PatchMapping(path = "/update")
//    public ResponseEntity<CreateProductResponseDto> update(@RequestBody CreateProductRequestDto createProductRequestDto){
//        Product updateProduct = productService.update(createProductRequestDto);
//        CreateProductResponseDto responseDto = new CreateProductResponseDto(updateProduct);
//        return ResponseEntity.ok(responseDto);
//    }
}