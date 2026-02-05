package marketplace.service.productService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.ProductRequestDto;
import marketplace.entity.Product;
import marketplace.repository.product.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    @Transactional
    public Product save(ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto);
        return productRepo.save(product);
    }

    @Transactional(readOnly = true)
    public Optional<Product> find(int id) {
        return productRepo.find(id);
    }

    @Transactional
    public Optional<Product> merge(int id, ProductRequestDto productRequestDto) {
        return productRepo.find(id).map(product -> {
            product.setName(productRequestDto.getName());
            product.setPrice(productRequestDto.getPrice());
            product.setQuantity(productRequestDto.getQuantity());
            return productRepo.merge(product);
        });
    }

    @Transactional
    public Optional<Boolean> remove(int id) {
        return productRepo.find(id).map(product -> {
            productRepo.remove(product);
            return true;
        });
    }
}
