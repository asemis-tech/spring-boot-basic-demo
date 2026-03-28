package com.chemical.dto.request;

import lombok.NonNull;

public class AppCreateRequestDTO {
    @NonNull
    private String code;
    private String name;
    private String type;
    private String status;

}
