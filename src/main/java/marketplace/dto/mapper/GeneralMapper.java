package marketplace.dto.mapper;

import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.dto.basketDto.BasketResponseDto;
import marketplace.dto.customerDto.CustomerRequestDto;
import marketplace.dto.customerDto.CustomerResponseDto;
import marketplace.dto.productDto.ProductRequestDto;
import marketplace.dto.productDto.ProductResponseDto;
import marketplace.entity.Basket;
import marketplace.entity.Customer;
import marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface GeneralMapper {

    CustomerResponseDto toResponse(Customer customer);

    Customer toEntity(CustomerRequestDto requestDto);

    void updateFromDto(CustomerRequestDto requestDto, @MappingTarget() Customer customer);

    ProductResponseDto toResponse(Product product);

    Product toEntity(ProductRequestDto requestDto);

    void updateFromDto(ProductRequestDto requestDto, @MappingTarget() Product product);

    @Mapping(target = "customerId", expression = "java(basket.getCustomer().getId())")
    @Mapping(target = "productId", expression = "java(basket.getProduct().getId())")
    BasketResponseDto toResponse(Basket basket);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "productId", target = "product.id")
    Basket toEntity(BasketRequestDto requestDto);

    void updateFromDto(BasketRequestDto requestDto, @MappingTarget() Basket basket);
}