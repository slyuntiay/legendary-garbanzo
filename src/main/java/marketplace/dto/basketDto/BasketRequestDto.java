package marketplace.dto.basketDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BasketRequestDto {
    @NotBlank(message = "А кто покупатель, еблан?!")
    private int clientId;

    @NotBlank(message = "А что покупают, еблан?!")
    private int productId;

    @NotBlank(message = "А сколько покупают, еблан?!")
    private int quantity;
}
