package marketplace.dto.basketDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Basket;

@RequiredArgsConstructor
@Getter
public class CreateBasketResponseDto {
    private final int clientId;
    private final int productId;
    private final int quantity;
}
