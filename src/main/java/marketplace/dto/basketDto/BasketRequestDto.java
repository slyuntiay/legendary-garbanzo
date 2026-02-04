package marketplace.dto.basketDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;
import marketplace.entity.Product;

@RequiredArgsConstructor
@Getter
public class BasketRequestDto {
    private Client client;
    private Product product;
    private Integer quantity;
}
