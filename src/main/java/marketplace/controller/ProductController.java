package marketplace.controller;

import lombok.RequiredArgsConstructor;
import marketplace.domain.entity.Product;
import marketplace.dto.ProductDto;
import marketplace.dto.ProductResponse;
import marketplace.repository.product.ProductRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepo productRepo;

    @PostMapping("/initTable")
    public ResponseEntity<String> initTable() {
        productRepo.createTable();
        return ResponseEntity.ok("Таблица создана");
    }
    @PostMapping("/dropTable")
    public ResponseEntity<String> dropTable() {
        productRepo.dropTable();
        return ResponseEntity.ok("Таблица удалена");
    }
    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductDto productDto) {
        Product product = new Product(productDto.getName(), productDto.getPrice(), productDto.getQuantity());

        Product createdProduct = productRepo.create(product);

        ProductResponse response = new ProductResponse();

        response.setId(createdProduct.getQuantity());
        response.setName(createdProduct.getName());
        response.setPrice(createdProduct.getPrice());
        response.setQuantity(createdProduct.getQuantity());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
