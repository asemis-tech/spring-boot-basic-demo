package com.chemical.dto.response;


import com.chemical.dto.BaseDTO;
import com.chemical.entity.App;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDTO extends BaseDTO {
    private UUID id;
    private String code;
    private String name;
    private String status;
    private List<App> apps;
}
