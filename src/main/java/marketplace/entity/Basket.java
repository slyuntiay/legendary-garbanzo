package marketplace.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.service.clientService.ClientService;
import marketplace.service.productService.ProductService;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Basket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    public Basket(BasketRequestDto basketRequestDto, ClientService clientService, ProductService productService) {
        this.customer = clientService.find(basketRequestDto.getClientId()).orElseThrow();
        this.product = productService.find(basketRequestDto.getProductId()).orElseThrow();
        this.quantity = basketRequestDto.getQuantity();
    }
}
