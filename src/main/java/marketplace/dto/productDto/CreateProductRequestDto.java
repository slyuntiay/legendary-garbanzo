package marketplace.dto.productDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateProductRequestDto {
    private final String name;
    private final double price;
    private final int quantity;
}
