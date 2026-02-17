package marketplace.service.productService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Product save(Product product) {
        log.info("SAVE product: name={}, price={}, quantity={}",
                product.getName(), product.
                        getPrice(),product.getQuantity());

        try {
            log.info("SAVE OK: productId={}", product.getId());
            return productRepo.save(product);
        } catch (Exception e) {
            log.error("SAVE FAILED: name={}, price={}, quantity={}, error{}",
                    product.getName(), product.getPrice(),
                    product.getQuantity(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<Product> find(long id) {
        log.debug("FIND product: id={}", id);
        return productRepo.find(id);
    }

    @Transactional
    public Optional<Product> merge(long id, Product product) {
        log.info("MERGE product: id={}, name={}, price={}, quantity={}",
                id, product.getName(), product.getPrice(), product.getQuantity());

        return productRepo.find(id).map(p -> {
            log.debug("MERGE updating product: id={}", id);
            Product merged = productRepo.merge(p);
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
