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

    public Product delete(int id) {
        Product product = new Product(productRepo.delete(id));
        if(product == null){
            throw new RuntimeException("такой id нелья удалить" + id + "пошел нахуй");
        }
        return product;
    }

    public Product update(Product product) {
        productRepo.update(product);
        return product;
    }

    public Product read(int id)  {
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
