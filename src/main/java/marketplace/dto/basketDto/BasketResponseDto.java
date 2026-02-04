package marketplace.dto.basketDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Basket;
import marketplace.entity.Client;

@RequiredArgsConstructor
@Getter
public class BasketResponseDto {
    private final Long id;
    private final Client client;
    private final Long productId;
    private final int quantity;

    public BasketResponseDto(Basket basket) {
        this.id = basket.getId();
        this.client = basket.getClient();
        this.productId = basket.getProductId();
        this.quantity = basket.getQuantity();
    }
}
