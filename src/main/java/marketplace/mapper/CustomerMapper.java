package marketplace.mapper;

import marketplace.dto.customerDto.CustomerRequest;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "role", source = "user.role")
    CustomerResponse toResponse(Customer customer);

    Customer toEntity(CustomerRequest requestDto);

    Customer updateFromDto(CustomerRequest requestDto, @MappingTarget() Customer customer);

    Customer toEntity(UserRegisterRequest request);
}
