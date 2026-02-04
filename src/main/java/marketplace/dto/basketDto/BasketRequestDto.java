package marketplace.dto.basketDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;

@RequiredArgsConstructor
@Getter
public class BasketRequestDto {
    @NotBlank(message = "А кто покупатель, еблан?!")
    private Client client;

    @NotBlank(message = "А что покупают, еблан?!")
    private Long productId;

    @NotBlank(message = "А сколько покупают, еблан?!")
    private int quantity;
}
