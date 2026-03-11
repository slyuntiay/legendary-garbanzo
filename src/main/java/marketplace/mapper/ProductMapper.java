package marketplace.mapper;

import marketplace.dto.product.ProductRequest;
import marketplace.dto.product.ProductResponse;
import marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);

    Product toEntity(ProductRequest requestDto);

    void updateFromDto(ProductRequest requestDto, @MappingTarget() Product product);
}
