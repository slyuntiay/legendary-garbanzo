package marketplace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import marketplace.dto.productDto.ProductRequestDto;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    public Product(ProductRequestDto createProductRequestDto) {
        this.name = createProductRequestDto.getName();
        this.price = createProductRequestDto.getPrice();
        this.quantity = createProductRequestDto.getQuantity();
    }
}
