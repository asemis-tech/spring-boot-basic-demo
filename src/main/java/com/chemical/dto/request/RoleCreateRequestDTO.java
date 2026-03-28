package com.chemical.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleCreateRequestDTO {
    private String code;
    private String name;
    private String description;
}
