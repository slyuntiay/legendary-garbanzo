package marketplace.service.basketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.dto.basketDto.BasketResponseDto;
import marketplace.dto.mapper.GeneralMapper;
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
    private final GeneralMapper generalMapper;

    @Transactional
    public BasketResponseDto save(BasketRequestDto basketRequestDto) {
        log.info("SAVE basket: clientId={}, productId={}, quantity={}",
                basketRequestDto.getCustomerId(), basketRequestDto.getProductId(), basketRequestDto.getQuantity());

        try {
            Basket basket = basketRepo.save(generalMapper.toEntity(basketRequestDto));
            log.info("SAVE OK: basketId={}", basket.getId());
            return generalMapper.toResponse(basket);
        } catch (Exception e) {
            log.error("SAVE FAILED: clientId={}, productId={}, error={}",
                    basketRequestDto.getCustomerId(), basketRequestDto.getProductId(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<BasketResponseDto> find(long id) {
        log.debug("FIND basket: id={}", id);
        return basketRepo.find(id).map(generalMapper::toResponse);
    }

    @Transactional
    public Optional<BasketResponseDto> merge(long id, BasketRequestDto basketRequestDto) {
        log.info("MERGE basket: id={}, quantity={}", id, basketRequestDto.getQuantity());

        return basketRepo.find(id).map(basket -> {
            log.debug("MERGE updating basket: id={}", id);
            generalMapper.updateFromDto(basketRequestDto, basket);
            Basket merged = basketRepo.merge(basket);
            log.info("MERGE OK: basketId={}", merged.getId());
            return generalMapper.toResponse(merged);
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
