package marketplace.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.basketDto.BasketRequestDto;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Basket extends BaseEntity {

    @Column(nullable = false)
    private int clientId;

    @Column(nullable = false)
    private int productId;

    @Column(nullable = false)
    private int quantity;

    public Basket(BasketRequestDto basketRequestDto){
        this.clientId = basketRequestDto.getClientId();
        this.productId = basketRequestDto.getProductId();
        this.quantity = basketRequestDto.getQuantity();
    }
}
