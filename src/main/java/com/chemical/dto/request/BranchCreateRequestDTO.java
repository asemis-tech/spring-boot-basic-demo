package com.chemical.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class BranchCreateRequestDTO {
    private UUID companyId;
    private String code;
    private String name;
    private String address;
    private String status;
}
