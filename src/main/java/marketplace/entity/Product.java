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
@Table(name = "product_table")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    public Product(ProductRequestDto createProductRequestDto) {
        this.name = createProductRequestDto.getName();
        this.price = createProductRequestDto.getPrice();
        this.quantity = createProductRequestDto.getQuantity();
    }

    public Product(int id, String name, double price, int quantity) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

//    @Override
//    public String toString() {
//        return id + " " + name + " " + price + " тенге за штуку";
//    }
}
