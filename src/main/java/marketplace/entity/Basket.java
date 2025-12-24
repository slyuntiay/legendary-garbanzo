package marketplace.entity;

import lombok.Getter;
import lombok.Setter;
import marketplace.dto.basketDto.CreateBasketRequestDto;

@Getter
@Setter
public class Basket extends Entity {
    private int clientId;
    private int productId;
    private int quantity;

    public Basket(CreateBasketRequestDto createBasketRequestDto){
        this.clientId = createBasketRequestDto.getClientId();
        this.productId = createBasketRequestDto.getProductId();
        this.quantity = createBasketRequestDto.getQuantity();
    }
}
