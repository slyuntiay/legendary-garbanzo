package marketplace.entity;

import lombok.*;
import marketplace.dto.clientDto.CreateClientRequestDto;
import marketplace.dto.productDto.CreateProductRequestDto;

import java.util.Objects;

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

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, String name, double price, int quantity) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(price, product.price) == 0 && quantity == product.quantity && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
