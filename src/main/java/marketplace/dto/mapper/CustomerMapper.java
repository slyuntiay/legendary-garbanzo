package marketplace.dto.mapper;

import marketplace.dto.customerDto.CustomerRequestDto;
import marketplace.dto.customerDto.CustomerResponseDto;
import marketplace.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto toResponse(Customer customer);
    Customer toEntity(CustomerRequestDto requestDto);
}