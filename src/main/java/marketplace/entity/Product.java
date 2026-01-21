package marketplace.entity;

import lombok.*;
import marketplace.dto.productDto.CreateProductRequestDto;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class Product extends Entity {
    private String name;
    private double price;
    private int quantity;

    public Product(CreateProductRequestDto createProductRequestDto) {
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

    @Override
    public String toString() {
        return id + " " + name + " " + price + " тенге за штуку";
    }
}
