package marketplace.dto.contractor.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSetUpdate implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private Set<ProductDto> products;
}