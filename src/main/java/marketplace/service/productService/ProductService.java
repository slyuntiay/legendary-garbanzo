package marketplace.service.productService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.CreateProductRequestDto;
import marketplace.entity.Product;
import marketplace.repository.product.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product create(CreateProductRequestDto createProductRequestDto) {
        Product product = new Product(createProductRequestDto);
        return productRepo.create(product);
    }

    public void delete(int id) {
        Product product = productRepo.read(id);
        if (product == null) {
            throw new RuntimeException("такой id нелья удалить" + id + "пошел нахуй");

        }
        productRepo.delete(id);
    }

    public Product update(int id, CreateProductRequestDto createProductRequestDto) {
        Product product = productRepo.read(id);
        if (product == null) {
            throw new RuntimeException("не смог найти продукт для обновления");
        }
        product.setName(createProductRequestDto.getName());
        product.setPrice(createProductRequestDto.getPrice());
        product.setQuantity(createProductRequestDto.getQuantity());
        return productRepo.update(product);
    }

    public Product read(int id) {
        Product product = productRepo.read(id);
        if (product == null) {
            throw new RuntimeException("такого id нет" + id + " пошел нахуй!");
        }
        return product;
    }


    public List<Product> readAll() {
        return productRepo.readAll();
    }
}
