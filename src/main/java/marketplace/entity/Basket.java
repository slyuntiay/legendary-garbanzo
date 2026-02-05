package marketplace.entity;


import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    public Basket(BasketRequestDto basketRequestDto){
        this.client = basketRequestDto.getClient();
        this.product = basketRequestDto.getProduct();
        this.quantity = basketRequestDto.getQuantity();
    }
}
