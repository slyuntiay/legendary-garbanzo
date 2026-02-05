package marketplace.dto.basketDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;
import marketplace.entity.Product;

@RequiredArgsConstructor
@Getter
public class BasketRequestDto {
    @NotBlank(message = "Кто?")
    private Client client;

    @NotBlank(message = "Что?")
    private Product product;

    @NotBlank(message = "Сколько?")
    private Integer quantity;
}
