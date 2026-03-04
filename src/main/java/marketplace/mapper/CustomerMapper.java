package marketplace.mapper;

import marketplace.dto.customerDto.CustomerRequest;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse toResponse(Customer customer);

    Customer toEntity(CustomerRequest requestDto);

    Customer updateFromDto(CustomerRequest requestDto, @MappingTarget() Customer customer);

    Customer toEntity(UserRegisterRequest request);
}
