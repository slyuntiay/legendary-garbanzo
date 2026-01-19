package marketplace.dto.basketDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateBasketRequestDto {
    @NotBlank(message = "А кто покупатель, еблан?!")

    private int clientId;

    @NotBlank(message = "А что покупают, еблан?!")
    private int productId;

    private int quantity;

}
