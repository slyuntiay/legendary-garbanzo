package marketplace.dto.basketDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Basket;
import marketplace.entity.Client;
import marketplace.entity.Product;

@Getter
public class BasketResponseDto {
    private final Long id;
    private final Long clientId;
    private final Long productId;
    private final Integer quantity;

    public BasketResponseDto(Basket basket) {
        this.id = basket.getId();
        this.clientId = basket.getClient().getId();
        this.productId = basket.getProduct().getId();
        this.quantity = basket.getQuantity();
    }
}
