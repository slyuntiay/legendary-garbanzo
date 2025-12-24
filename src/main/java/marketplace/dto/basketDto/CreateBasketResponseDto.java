package marketplace.dto.basketDto;

import marketplace.entity.Basket;

public class CreateBasketResponseDto {
    private final int clientId;
    private final int productId;
    private final int quantity;

    public CreateBasketResponseDto(Basket basket) {
        this.clientId = basket.getClientId();
        this.productId = basket.getProductId();
        this.quantity = basket.getQuantity();
    }
}
