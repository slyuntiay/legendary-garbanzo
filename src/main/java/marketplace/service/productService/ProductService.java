package marketplace.service.productService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.CreateProductRequestDto;
import marketplace.entity.Product;
import marketplace.repository.product.ProductRepo;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product create(CreateProductRequestDto createProductRequestDto) {
        Product product = new Product(createProductRequestDto);
        return productRepo.create(product);
    }

    public Product read(int id) {
        return productRepo.read(id)
                .orElseThrow(() -> new NoSuchElementException("Продукт не найден"));
    }


    public Product update(int id, CreateProductRequestDto createProductRequestDto) {
        Product product = read(id);
        product.setName(createProductRequestDto.getName());
        product.setPrice(createProductRequestDto.getPrice());
        product.setQuantity(createProductRequestDto.getQuantity());
        return productRepo.update(product);
    }

    public void delete(int id) {
        productRepo.delete(id);
    }
}
