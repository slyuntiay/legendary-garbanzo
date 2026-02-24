package marketplace.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequest {
    private Long id;
    private List<ProductDto> productList;
}