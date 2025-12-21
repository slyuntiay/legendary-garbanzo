package marketplace.service;

import lombok.RequiredArgsConstructor;
import marketplace.dto.productDto.CreateProductRequestDto;
import marketplace.entity.Product;
import marketplace.repository.product.ProductRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService{
    private final ProductRepo productRepo;

    public Product create(CreateProductRequestDto createProductRequestDto) {
        Product product = new Product(createProductRequestDto);
        return productRepo.create(product);
    }
    public Product delete(int id){
        productRepo.delete(id);
        return null;
    }
}
