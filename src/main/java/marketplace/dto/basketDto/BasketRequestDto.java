package marketplace.dto.basketDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;
import marketplace.entity.Product;

@RequiredArgsConstructor
@Getter
public class BasketRequestDto {
    @NotBlank(message = "А кто покупатель, еблан?!")
    private Client client;

    @NotBlank(message = "А что покупают, еблан?!")
    private Product product;

    @NotBlank(message = "А сколько покупают, еблан?!")
    private Integer quantity;
}
