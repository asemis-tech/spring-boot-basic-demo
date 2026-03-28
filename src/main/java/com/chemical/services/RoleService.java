package com.chemical.services;

import com.chemical.dto.request.RoleCreateRequestDTO;
import com.chemical.dto.request.RoleUpdateRequestDTO;
import com.chemical.dto.response.RoleResponseDTO;
import com.chemical.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<RoleResponseDTO> getAllRoles();

    Role findById(UUID roleId);

    RoleResponseDTO findDetailsById(UUID roleId);

    Role save(RoleCreateRequestDTO request);

    Role update(UUID roleId, RoleUpdateRequestDTO request);

    void delete(UUID roleId);
}
