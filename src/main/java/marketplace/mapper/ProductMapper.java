package marketplace.mapper;

import marketplace.dto.productDto.ProductRequest;
import marketplace.dto.productDto.ProductResponse;
import marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);

    Product toEntity(ProductRequest requestDto);

    void updateFromDto(ProductRequest requestDto, @MappingTarget() Product product);
}
