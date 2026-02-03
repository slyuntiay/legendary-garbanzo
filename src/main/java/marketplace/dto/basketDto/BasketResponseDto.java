package marketplace.dto.basketDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Basket;

@RequiredArgsConstructor
@Getter
public class BasketResponseDto {
    private final int id;
    private final int clientId;
    private final int productId;
    private final int quantity;

    public BasketResponseDto(Basket basket) {
        this.id = basket.getId();
        this.clientId = basket.getClientId();
        this.productId = basket.getProductId();
        this.quantity = basket.getQuantity();
    }
}
