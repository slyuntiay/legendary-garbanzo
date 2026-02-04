package marketplace.dto.basketDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Basket;
import marketplace.entity.Client;
import marketplace.entity.Product;

@RequiredArgsConstructor
@Getter
public class BasketResponseDto {
    private final Long id;
    private final Client client;
    private final Product product;
    private final Integer quantity;

    public BasketResponseDto(Basket basket) {
        this.id = basket.getId();
        this.client = basket.getClient();
        this.product = basket.getProduct();
        this.quantity = basket.getQuantity();
    }
}
