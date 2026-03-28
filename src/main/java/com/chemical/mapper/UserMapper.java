package com.chemical.mapper;

import com.chemical.dto.request.UserCreateRequestDTO;
import com.chemical.dto.request.UserUpdateRequestDTO;
import com.chemical.dto.response.UserResponseDTO;
import com.chemical.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy; // Quan trọng: Thêm dòng này

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE // Phép thuật tắt 12 lỗi nằm ở đây
)
public interface UserMapper {

    // Ánh xạ từ Entity sang Response: Chủ động lờ đi các trường DTO có mà Entity không có
    @Mapping(target = "avatar", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "role", ignore = true)
    UserResponseDTO convertToUserResponse(User user);

    // Ánh xạ từ Request sang Entity: Nhờ ReportingPolicy.IGNORE, nó sẽ tự lờ đi 12 trường bị thiếu
    User userCreateRequestConvertToUser(UserCreateRequestDTO request);

    // Ánh xạ từ Update Request sang Entity
    void userUpdateRequestConvertToUser(@MappingTarget User user, UserUpdateRequestDTO request);
}