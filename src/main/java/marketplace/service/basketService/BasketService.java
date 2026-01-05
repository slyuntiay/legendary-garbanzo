package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepo basketRepo;

    public Basket create(CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = new Basket(createBasketRequestDto);
        return basketRepo.create(basket);
    }
    public Optional<Basket> read(int id) {
        return basketRepo.read(id);
    }
    public Basket update(Basket basket) {
        return basketRepo.update(basket);
    }
    public Basket delete(int id) {
      return null;
    }
}
