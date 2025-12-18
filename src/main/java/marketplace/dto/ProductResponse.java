package marketplace.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private int id;
    private String name;
    private double price;
    private int quantity;
}
