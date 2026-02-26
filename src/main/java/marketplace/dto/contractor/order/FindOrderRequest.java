package marketplace.dto.contractor.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import marketplace.dto.contractor.product.ProductDto;

import java.util.List;

@Data
@AllArgsConstructor
public class FindOrderRequest {
    private Long id;
    private List<ProductDto> productList;
}
