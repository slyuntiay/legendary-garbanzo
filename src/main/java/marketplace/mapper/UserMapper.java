package marketplace.mapper;

import marketplace.dto.userDto.UserProfileResponse;
import marketplace.dto.userDto.UserRegisterRequest;
import marketplace.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserProfileResponse toResponse(User user);

    User toEntity(UserRegisterRequest requestDto);

    void updateFromDto(UserRegisterRequest requestDto, @MappingTarget() User user);
}
