package marketplace.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;
import marketplace.dto.contractor.product.ProductDto;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractorResponse {
    private String message;
    private List<ProductDto> productList;
}