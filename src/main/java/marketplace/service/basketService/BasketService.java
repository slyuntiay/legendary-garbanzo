package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.entity.Basket;
import marketplace.repository.basket.BasketRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepo basketRepo;


    @Transactional
    public Basket save(Basket basket) {
        log.info("SAVE basket: clientId={}, productId={}, quantity={}",
                basket.getCustomer().getId(), basket.getProduct().getId(), basket.getQuantity());

        try {
            log.info("SAVE OK: basketId={}", basket.getId());
            return basketRepo.save(basket);
        } catch (Exception e) {
            log.error("SAVE FAILED: clientId={}, productId={}, error={}",
                    basket.getCustomer().getId(), basket.getProduct().getId(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<Basket> find(long id) {
        log.debug("FIND basket: id={}", id);
        return basketRepo.find(id);
    }

    @Transactional
    public Optional<Basket> merge(long id, Basket basket) {
        log.info("MERGE basket: id={}, quantity={}", id, basket.getQuantity());

        return basketRepo.find(id).map(b -> {
            log.debug("MERGE updating basket: id={}", id);
            Basket merged = basketRepo.merge(b);
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
