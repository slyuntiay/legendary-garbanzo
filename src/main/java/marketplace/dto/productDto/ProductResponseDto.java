package marketplace.dto.productDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Product;

@RequiredArgsConstructor
@Getter
public class ProductResponseDto {
    private final int id;
    private final String name;
    private final double price;
    private final int quantity;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}
