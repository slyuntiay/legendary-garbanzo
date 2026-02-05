package marketplace.dto.basketDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BasketRequestDto {
    private Long clientId;
    private Long productId;
    private Integer quantity;
}
