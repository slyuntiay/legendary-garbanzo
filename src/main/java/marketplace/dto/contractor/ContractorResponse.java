package marketplace.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;
import marketplace.dto.productDto.ProductResponseDto;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractorResponse {
    private String message;
    private List<ProductResponseDto> productList;
}