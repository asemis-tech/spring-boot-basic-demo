package com.chemical.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class BranchUpdateResponseDTO {
    private UUID companyId;
    private String name;
    private String code;
    private String address;
    private String status;
}
