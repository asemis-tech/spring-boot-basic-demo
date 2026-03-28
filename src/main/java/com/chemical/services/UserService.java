package com.chemical.services;

import com.chemical.common.query.SearchRequest;
import com.chemical.dto.request.UserCreateRequestDTO;
import com.chemical.dto.request.UserUpdateRequestDTO;
import com.chemical.dto.response.UserResponseDTO;
import com.chemical.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface UserService {
    Page<UserResponseDTO> search(SearchRequest request);
    User save(UserCreateRequestDTO request);
    UserResponseDTO currentUserDetails();
    UserResponseDTO findByEmailAuth(String email);
    List<UserResponseDTO> getAllUsers();
    User update(UUID userId, UserUpdateRequestDTO request);
    void delete(UUID userId);
}
