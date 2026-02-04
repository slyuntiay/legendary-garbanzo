package marketplace.repository.basket;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Basket;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class BasketRepo {
    private EntityManager entityManager;

    public Basket save(Basket basket) {
        entityManager.persist(basket);
        return basket;
    }

    public Optional<Basket> find(int id) {
        return Optional.ofNullable(entityManager.find(Basket.class, id));
    }

    public Basket merge(Basket basket) {
        return entityManager.merge(basket);
    }

    public void remove(Basket basket) {
        entityManager.remove(basket);
    }
}

