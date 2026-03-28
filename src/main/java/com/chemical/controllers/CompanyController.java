package com.chemical.controllers;

import com.chemical.common.BaseResponse;
import com.chemical.dto.request.CompanyCreateRequestDTO;
import com.chemical.dto.request.CompanyUpdateRequestDTO;
import com.chemical.dto.response.CompanyResponseDTO;
import com.chemical.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@Tag(name = "Company Controller", description = "Endpoints for managing company")
@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
@CrossOrigin("*")

public class CompanyController {
    public final CompanyService companyService;

    @Operation(summary = "Get all companies")
    @GetMapping
    public BaseResponse<List<CompanyResponseDTO>> getAllCompanies() {
        List<CompanyResponseDTO> companies = companyService.getAllCompanies();
        return BaseResponse.ok(companies);
    }

    @Operation(summary = "Get company details by ID")
    @GetMapping("/{id}")
    public BaseResponse<CompanyResponseDTO> getDetailCompany(@PathVariable("id") UUID id) {
        CompanyResponseDTO company = companyService. getCompaniesDetailById(id);
        return BaseResponse.ok(company);
    }

    @Operation(summary = "Create a new company")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<CompanyResponseDTO> createCompany(@RequestBody CompanyCreateRequestDTO request) {
        CompanyResponseDTO response = companyService.save(request);
        return BaseResponse.created(response);
    }

    @Operation(summary = "Update an existing company")
    @PutMapping("/{id}")
    public BaseResponse<CompanyResponseDTO> updateCompany(@PathVariable("id") UUID id, @RequestBody CompanyUpdateRequestDTO request) {
        CompanyResponseDTO updatedCompany = companyService.update(id, request);

        return BaseResponse.ok(updatedCompany);
    }

    @Operation(summary = "Delete company by ID")
    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteCompany(@PathVariable("id") UUID id) {
        log.info("Request to delete Company with id: {}", id);

        companyService.delete(id);

        return BaseResponse.ok(null);
    }


}
