package marketplace.dto.contractor.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import marketplace.dto.contractor.product.ProductDto;

import java.util.Set;

@Data
@AllArgsConstructor
public class FindOrderRequest {
    private Long id;
    private Set<ProductDto> products;
}
