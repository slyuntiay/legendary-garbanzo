package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepo basketRepo;

    @Transactional
    public Basket save(BasketRequestDto basketRequestDto) {
        Basket basket = new Basket(basketRequestDto);
        return basketRepo.save(basket);
    }

    public Basket find(int id) {
        return basketRepo.find(id).orElseThrow(() -> new NoSuchElementException("Корзина не найдена"));
    }

    @Transactional
    public Basket merge(int id, BasketRequestDto basketRequestDto) {
        Basket basket = find(id);
        basket.setQuantity(basketRequestDto.getQuantity());
        return basketRepo.merge(basket);
    }

    @Transactional
    public Optional<Object> remove(int id) {
        return basketRepo.find(id).map(basket -> {
            basketRepo.remove(basket);
            return true;
        });
    }
}
