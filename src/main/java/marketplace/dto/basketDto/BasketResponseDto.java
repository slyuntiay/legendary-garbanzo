package marketplace.dto.basketDto;

import lombok.Data;

@Data
public class BasketResponseDto {
    private final Long id;
    private final Long clientId;
    private final Long productId;
    private final Integer quantity;

}
