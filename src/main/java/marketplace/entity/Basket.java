package marketplace.entity;

import lombok.Getter;
import lombok.Setter;
import marketplace.dto.basketDto.CreateBasketRequestDto;

import java.util.Objects;

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

    public Basket(int clientId, int productId, int quantity) {
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return clientId + ";" + productId + ";" + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return clientId == basket.clientId && productId == basket.productId && quantity == basket.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, productId, quantity);
    }
}
