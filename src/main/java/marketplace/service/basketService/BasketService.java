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

    public Optional<Basket> find(int id) {
        return basketRepo.find(id);
    }

    @Transactional
    public Optional<Basket> merge(int id, BasketRequestDto basketRequestDto) {
        return basketRepo.find(id).map(basket -> {
            basket.setQuantity(basketRequestDto.getQuantity());
            return basketRepo.merge(basket);
        });
    }

    @Transactional
    public Optional<Boolean> remove(int id) {
        return basketRepo.find(id).map(basket -> {
            basketRepo.remove(basket);
            return true;
        });
    }
}
