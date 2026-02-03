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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @Column(nullable = false)
    private Client client;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int quantity;

    public Basket(BasketRequestDto basketRequestDto){
        this.client = basketRequestDto.getClient();
        this.productId = basketRequestDto.getProductId();
        this.quantity = basketRequestDto.getQuantity();
    }
}
