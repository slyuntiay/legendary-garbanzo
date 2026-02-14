package marketplace.dto.productDto;

import lombok.Data;


@Data
public class ProductRequestDto {
    private final String name;
    private final double price;
    private final int quantity;
}
