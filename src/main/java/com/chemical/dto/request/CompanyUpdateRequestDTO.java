package com.chemical.dto.request;

import com.chemical.entity.Company;
import lombok.Data;

@Data
public class CompanyUpdateRequestDTO {
    private String code;
    private String name;
    private String status;
}
