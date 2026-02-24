package marketplace.dto.contractor;

import lombok.Data;

@Data
public class ProductDto {
    private final Long id;
    private final String name;
    private final Double price;
    private final Integer quantity;
}
