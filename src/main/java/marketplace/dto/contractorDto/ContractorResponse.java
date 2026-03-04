package marketplace.dto.contractorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.dto.contractorDto.product.ProductDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractorResponse {
    private String message;
    private Set<ProductDto> products;
}