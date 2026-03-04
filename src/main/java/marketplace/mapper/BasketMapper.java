package marketplace.mapper;

import marketplace.dto.basketDto.BasketRequest;
import marketplace.dto.basketDto.BasketResponse;
import marketplace.entity.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BasketMapper {
    @Mapping(target = "customerId", expression = "java(basket.getCustomer().getId())")
    @Mapping(target = "productId", expression = "java(basket.getProduct().getId())")
    BasketResponse toResponse(Basket basket);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "productId", target = "product.id")
    Basket toEntity(BasketRequest requestDto);

    void updateFromDto(BasketRequest requestDto, @MappingTarget() Basket basket);
}
