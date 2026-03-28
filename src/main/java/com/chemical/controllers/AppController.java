package com.chemical.controllers;

import com.chemical.common.BaseResponse;
import com.chemical.dto.request.AppCreateRequestDTO;
import com.chemical.entity.App;
import com.chemical.services.AppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "App Controller", description = "Endpoints for managing apps")
@RestController("/api/app")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AppController {
    private final AppService appService;

//    @Operation(summary = "Create app")
//    @PostMapping
//

}
