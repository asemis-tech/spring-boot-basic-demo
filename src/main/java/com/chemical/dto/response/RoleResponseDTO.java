package com.chemical.dto.response;

import com.chemical.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDTO extends BaseDTO {
    private UUID id;
    private String code;
    private String name;
    private String description;


//    private UUID id;
//    private String name;
//    private String slug;
//    private List<PermissionResponseDTO> permissions;
}
