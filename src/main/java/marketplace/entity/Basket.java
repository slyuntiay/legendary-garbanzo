package marketplace.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.basketDto.CreateBasketRequestDto;

@NoArgsConstructor
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

    public Basket(int id, int clientId, int productId, int quantity) {
        super(id);
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return clientId + ";" + productId + ";" + quantity;
    }
}
