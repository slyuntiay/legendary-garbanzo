package marketplace.service.productService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.productDto.ProductRequestDto;
import marketplace.entity.Product;
import marketplace.repository.product.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    @Transactional
    public Product save(ProductRequestDto productRequestDto) {
        log.info("SAVE product: name={}, price={}, quantity={}",
                productRequestDto.getName(), productRequestDto.
                        getPrice(),productRequestDto.getQuantity());

        try {
            Product product = new Product(productRequestDto);
            Product saved = productRepo.save(product);
            log.info("SAVE OK: productId={}", saved.getId());
            return saved;
        } catch (Exception e) {
            log.error("SAVE FAILED: name={}, price={}, quantity={}, error{}",
                    productRequestDto.getName(), productRequestDto.getPrice(),
                    productRequestDto.getQuantity(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<Product> find(long id) {
        log.debug("FIND product: id={}", id);

        Optional<Product> product = productRepo.find(id);
        if (product.isPresent()) {
            log.debug("FIND OK: productId={}", id);
        } else {
            log.warn("FIND NOT FOUND: id={}", id);
        }
        return product;
    }

    @Transactional
    public Optional<Product> merge(long id, ProductRequestDto productRequestDto) {
        log.info("MERGE product: id={}, name={}, price={}, quantity={}",
                id, productRequestDto.getName(), productRequestDto.getPrice(),productRequestDto.getQuantity());

        return productRepo.find(id).map(product -> {
            log.debug("MERGE updating product: id={}", id);
            product.setName(productRequestDto.getName());
            product.setPrice(productRequestDto.getPrice());
            product.setQuantity(productRequestDto.getQuantity());
            Product merged = productRepo.merge(product);
            log.info("MERGE OK: productId={}", merged.getId());
            return merged;
        });
    }

    @Transactional
    public Optional<Boolean> remove(long id) {
        log.info("REMOVE product: id={}", id);

        return productRepo.find(id).map(product -> {
            log.debug("REMOVE deleting product: id={}", id);
            productRepo.remove(product);
            log.info("REMOVE OK: productId={}", id);
            return true;
        });
    }
}
