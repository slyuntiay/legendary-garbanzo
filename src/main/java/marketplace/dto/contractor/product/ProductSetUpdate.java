package marketplace.dto.contractor.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
public class ProductSetUpdate implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private Set<ProductDto> products;
}