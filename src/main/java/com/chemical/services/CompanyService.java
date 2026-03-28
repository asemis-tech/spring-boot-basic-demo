package com.chemical.services;

import com.chemical.dto.request.CompanyCreateRequestDTO;
import com.chemical.dto.request.CompanyUpdateRequestDTO;
import com.chemical.dto.response.CompanyResponseDTO;
import com.chemical.entity.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    List<CompanyResponseDTO> getAllCompanies();
//    CompanyResponseDTO getCompaniesDetailById(UUID id);

    CompanyResponseDTO getCompaniesDetailById(UUID companyId);

    CompanyResponseDTO save(CompanyCreateRequestDTO request);
    CompanyResponseDTO update(UUID id, CompanyUpdateRequestDTO request);

    void delete(UUID id);
}
