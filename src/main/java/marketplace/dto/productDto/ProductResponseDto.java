package marketplace.dto.productDto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final Double price;
    private final Integer quantity;
}
