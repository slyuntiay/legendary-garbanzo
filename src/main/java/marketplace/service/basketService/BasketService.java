package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import marketplace.service.customerService.CustomerService;
import marketplace.service.productService.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepo basketRepo;
    private final CustomerService customerService;
    private final ProductService productService;

    @Transactional
    public Basket save(BasketRequestDto basketRequestDto) {
        log.info("SAVE basket: clientId={}, productId={}, quantity={}",
                basketRequestDto.getClientId(), basketRequestDto.getProductId(), basketRequestDto.getQuantity());

        try {
            Basket basket = new Basket(basketRequestDto, customerService, productService);
            Basket saved = basketRepo.save(basket);
            log.info("SAVE OK: basketId={}", saved.getId());
            return saved;
        } catch (Exception e) {
            log.error("SAVE FAILED: clientId={}, productId={}, error={}",
                    basketRequestDto.getClientId(), basketRequestDto.getProductId(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<Basket> find(long id) {
        log.debug("FIND basket: id={}", id);

        Optional<Basket> basket = basketRepo.find(id);
        if (basket.isPresent()) {
            log.debug("FIND OK: basketId={}", id);
        } else {
            log.warn("FIND NOT FOUND: id={}", id);
        }
        return basket;
    }

    @Transactional
    public Optional<Basket> merge(long id, BasketRequestDto basketRequestDto) {
        log.info("MERGE basket: id={}, quantity={}", id, basketRequestDto.getQuantity());

        return basketRepo.find(id).map(basket -> {
            log.debug("MERGE updating basket: id={}", id);
            basket.setQuantity(basketRequestDto.getQuantity());
            Basket merged = basketRepo.merge(basket);
            log.info("MERGE OK: basketId={}", merged.getId());
            return merged;
        });
    }

    @Transactional
    public Optional<Boolean> remove(long id) {
        log.info("REMOVE basket: id={}", id);

        return basketRepo.find(id).map(basket -> {
            log.debug("REMOVE deleting basket: id={}", id);
            basketRepo.remove(basket);
            log.info("REMOVE OK: basketId={}", id);
            return true;
        });
    }
}
