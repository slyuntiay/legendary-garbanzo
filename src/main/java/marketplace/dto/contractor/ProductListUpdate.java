package marketplace.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductListUpdate {
    private Long orderId;
    private List<ProductDto> productList;
}