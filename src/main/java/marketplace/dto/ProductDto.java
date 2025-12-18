package marketplace.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private double price;
    private int quantity;
}
