package marketplace.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.dto.contractor.product.ProductDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractorResponse {
    private String message;
    private Set<ProductDto> products;
}