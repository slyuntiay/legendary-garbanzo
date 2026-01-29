package marketplace.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.basketDto.CreateBasketRequestDto;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "basket_table")
public class Basket extends BaseEntity {
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
