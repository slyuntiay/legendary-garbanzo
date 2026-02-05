package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import marketplace.repository.client.ClientRepo;
import marketplace.repository.product.ProductRepo;
import marketplace.service.clientService.ClientService;
import marketplace.service.productService.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepo basketRepo;
    private final ClientService clientService;
    private final ProductService productService;

    @Transactional
    public Basket save(BasketRequestDto basketRequestDto) {
        Basket basket = new Basket(basketRequestDto, clientService, productService);
        return basketRepo.save(basket);
    }

    @Transactional(readOnly = true)
    public Optional<Basket> find(long id) {
        return basketRepo.find(id);
    }

    @Transactional
    public Optional<Basket> merge(long id, BasketRequestDto basketRequestDto) {
        return basketRepo.find(id).map(basket -> {
            basket.setQuantity(basketRequestDto.getQuantity());
            return basketRepo.merge(basket);
        });
    }

    @Transactional
    public Optional<Boolean> remove(long id) {
        return basketRepo.find(id).map(basket -> {
            basketRepo.remove(basket);
            return true;
        });
    }
}
