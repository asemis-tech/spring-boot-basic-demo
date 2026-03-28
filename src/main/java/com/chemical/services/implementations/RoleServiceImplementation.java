package com.chemical.services.implementations;

import com.chemical.common.errors.LogicException;
import com.chemical.common.errors.RecordNotFoundException;
import com.chemical.dto.request.RoleCreateRequestDTO;
import com.chemical.dto.request.RoleUpdateRequestDTO;
import com.chemical.dto.response.PermissionResponseDTO;
import com.chemical.dto.response.RoleResponseDTO;
import com.chemical.entity.Role;
import com.chemical.entity.RolePermission;
import com.chemical.mapper.RoleMapper;
import com.chemical.repositories.RolePermissionRepository;
import com.chemical.repositories.RoleRepository;
import com.chemical.services.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImplementation implements RoleService {

    RoleRepository roleRepository;
    RolePermissionRepository rolePermissionRepository;
    RoleMapper roleMapper;

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        return roleRepository.findAll().stream().map(roleMapper::convertToRoleResponse).toList();
    }

    @Override
    public Role findById(UUID roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new RecordNotFoundException(" Not found role with id : " + roleId));
    }

    @Override
    public RoleResponseDTO findDetailsById(UUID roleId) {
        Role role = findById(roleId);

        List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleId(roleId);
        role.setRolePermissions(rolePermissions);

        return roleMapper.convertToRoleResponse(role);
    }

    @Override
    public Role save(RoleCreateRequestDTO createRequest) {
        if (roleRepository.findByName(createRequest.getName()).isPresent()) {
            throw new LogicException("Role's already exist");
        }

        String nameToSlug = createRequest.getName().replaceAll(" ", "-").toLowerCase();

        if (roleRepository.findByCode(nameToSlug).isPresent()) {
            throw new LogicException("Role name's already exist");
        }

        Role role = roleMapper.convertRoleCreateToRole(createRequest);

        role.setName(createRequest.getName());
        role.setCode(nameToSlug);
        role.setCreated_by("user");
        role.setUpdated_by("user");
        role.setCreated_at(new Date());
        role.setUpdated_at(new Date());
        log.info("save user in service: " + role);

        return roleRepository.save(role);
    }

    @Override
    public Role update(UUID roleId, RoleUpdateRequestDTO updateRequest) {
        Role role = findById(roleId);
        String nameToSlug = updateRequest.getName().replaceAll(" ", "-").toLowerCase();

        if (roleRepository.findByCode(nameToSlug).isPresent() && !role.getCode().equals(nameToSlug)) {
            throw new LogicException("Role name's already exist");
        }

        role.setName(updateRequest.getName());
        role.setCode(nameToSlug);
        role.setUpdated_at(new Date());
        role.setUpdated_by("user");
        return roleRepository.save(role);
    }

    @Override
    public void delete(UUID roleId) {
        Role role = findById(roleId);
        roleRepository.delete(role);
    }
}
