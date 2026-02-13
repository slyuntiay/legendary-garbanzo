package marketplace.dto.productDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Product;

@RequiredArgsConstructor
@Getter
public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final double price;
    private final int quantity;
}
