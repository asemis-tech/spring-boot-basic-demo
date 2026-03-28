package com.chemical.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponseDTO {
    private String code;
    private String name;
    private String type;
    private String status;
}
