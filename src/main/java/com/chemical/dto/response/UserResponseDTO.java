package com.chemical.dto.response;

import com.chemical.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.chemical.entity.Role;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO extends BaseDTO {
    private UUID id;
    private String name;
    private String email;
    private String avatar;
    private String gender;
    private Role role;
}
