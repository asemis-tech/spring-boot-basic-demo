package com.chemical.mapper;

import com.chemical.dto.request.CompanyCreateRequestDTO;
import com.chemical.dto.request.CompanyUpdateRequestDTO;
import com.chemical.dto.response.CompanyResponseDTO;
import com.chemical.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CompanyMapper {
    CompanyResponseDTO toCompanyResponseDTO(Company company);
    Company convertCompanyRequestToCompany(CompanyCreateRequestDTO companyCreateRequestDTO);

    void updateCompanyFromDTO(CompanyUpdateRequestDTO dto, @MappingTarget Company entity);

}
