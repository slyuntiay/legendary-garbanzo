package marketplace.dto.contractor.product;


import lombok.Data;


import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer quantity;
}
