package marketplace.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductListUpdate implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private List<ProductDto> productList;
}