package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepo basketRepo;

    public Basket create(CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = new Basket(createBasketRequestDto);
        return basketRepo.create(basket);
    }

    public Basket read(int id) {
        return basketRepo.read(id).orElseThrow(() -> new NoSuchElementException("Корзина не найдена"));
    }

    public Basket readProduct(int clientId, int productId) {
        return basketRepo.readProduct(clientId, productId).orElseThrow(() -> new NoSuchElementException("Корзина не найдена"));
    }

    public Basket update(int clientId, int productId, CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = readProduct(clientId, productId);
        basket.setQuantity(createBasketRequestDto.getQuantity());
        return basketRepo.update(basket);
    }

    public void delete(int id) {
        basketRepo.delete(id);
    }
    public void deleteProduct(int clientId, int productId) {
        basketRepo.deleteProduct(clientId,productId);
    }
}
