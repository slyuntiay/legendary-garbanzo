package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.CreateBasketRequestDto;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepo basketRepo;

    public Basket create(CreateBasketRequestDto createBasketRequestDto) {
        Basket basket = new Basket(createBasketRequestDto);
        return basketRepo.create(basket);
    }
}
