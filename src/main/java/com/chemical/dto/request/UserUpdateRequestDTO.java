package com.chemical.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private UUID roleId;
}
