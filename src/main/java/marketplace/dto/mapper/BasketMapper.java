package marketplace.dto.mapper;

import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.dto.basketDto.BasketResponseDto;
import marketplace.entity.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BasketMapper {
    @Mapping(target = "customerId", expression = "java(basket.getCustomer().getId())")
    @Mapping(target = "productId", expression = "java(basket.getProduct().getId())")
    BasketResponseDto toResponse(Basket basket);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "productId", target = "product.id")
    Basket toEntity(BasketRequestDto requestDto);

    void updateFromDto(BasketRequestDto requestDto, @MappingTarget() Basket basket);
}
