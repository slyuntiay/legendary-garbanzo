package marketplace.dto.contractor.productListUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import marketplace.dto.productDto.ProductResponseDto;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductListUpdate {
    private List<ProductResponseDto> productList;
}