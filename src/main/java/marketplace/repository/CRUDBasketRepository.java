package marketplace.repository;

import marketplace.entity.Basket;

import java.util.Optional;

public interface CRUDBasketRepository {
    Basket create(Basket basket);

    Optional<Basket> read(int clientId, int productId);

    Basket update(Basket basket);

    void delete(int id);
}
