package marketplace.dto.mapper;

import marketplace.dto.productDto.ProductRequestDto;
import marketplace.dto.productDto.ProductResponseDto;
import marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDto toResponse(Product product);

    Product toEntity(ProductRequestDto requestDto);

    void updateFromDto(ProductRequestDto requestDto, @MappingTarget() Product product);
}
