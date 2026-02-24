package marketplace.dto.contractor;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String name;
    private final Double price;
    private final Integer quantity;
}
