package marketplace.dto.contractorDto.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer quantity;
}
