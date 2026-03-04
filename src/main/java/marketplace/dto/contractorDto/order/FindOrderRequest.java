package marketplace.dto.contractorDto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.dto.contractorDto.product.ProductDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindOrderRequest {
    private Long id;
    private Set<ProductDto> products;
}
