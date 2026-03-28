package com.chemical.services;

import com.chemical.dto.response.PermissionResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PermissionService {
    List<PermissionResponseDTO> getAllPermissions();

    List<PermissionResponseDTO> getPermissionDetailsById(UUID permissionId);

}
