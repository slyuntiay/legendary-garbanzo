package marketplace.dto.mapper;

import marketplace.dto.customerDto.CustomerRequestDto;
import marketplace.dto.customerDto.CustomerResponseDto;
import marketplace.dto.productDto.ProductRequestDto;
import marketplace.dto.productDto.ProductResponseDto;
import marketplace.entity.Customer;
import marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GeneralMapper {

    CustomerResponseDto toResponse(Customer customer);

    Customer toEntity(CustomerRequestDto requestDto);

    void updateFromDto(CustomerRequestDto requestDto, @MappingTarget() Customer customer);

    ProductResponseDto toResponse(Product product);

    Product toEntity(ProductRequestDto requestDto);

    void updateFromDto(ProductRequestDto requestDto, @MappingTarget() Product product);


}