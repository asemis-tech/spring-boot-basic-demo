package com.chemical.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class BranchResponseDTO {
    private UUID id;
    private UUID companyId;
    private String code;
    private String name;
    private String address;
    private String status;
}
