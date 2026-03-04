package marketplace.dto.contractorDto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.dto.contractorDto.product.ProductDto;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private Set<ProductDto> products;
}