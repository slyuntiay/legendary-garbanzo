package marketplace.repository.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    public Optional<Product> find(Long id) {
        return Optional.ofNullable(entityManager.find(Product.class, id));
    }

    public Product merge(Product product) {
        return entityManager.merge(product);
    }

    @Transactional
    public void remove(Product product) {
        entityManager.remove(product);
    }
}