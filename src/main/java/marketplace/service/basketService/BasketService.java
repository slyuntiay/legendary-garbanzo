package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Basket update(int id, CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = read(id);
        basket.setQuantity(createBasketRequestDto.getQuantity());
        return basketRepo.update(basket);
    }

    public void delete(int id) {
        basketRepo.delete(id);
    }

    public List<Basket> readAll(int clientId) {
        return basketRepo.readAll(clientId);
    }

    public void deleteAll(int clientId) {
        basketRepo.deleteAll(clientId);
    }
}
