package com.chemical.services.implementations;

import com.chemical.common.errors.RecordNotFoundException;
import com.chemical.dto.request.CompanyCreateRequestDTO;
import com.chemical.dto.request.CompanyUpdateRequestDTO;
import com.chemical.dto.response.CompanyResponseDTO;
import com.chemical.entity.Company;
import com.chemical.mapper.CompanyMapper;
import com.chemical.repositories.CompanyRepository;
import com.chemical.services.CompanyService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CompanyServiceImplementation implements CompanyService {

    CompanyRepository companyRepository;
    CompanyMapper companyMapper;

    @Override
    public List<CompanyResponseDTO> getAllCompanies() {
        return companyRepository.findAll().stream().map(companyMapper::toCompanyResponseDTO).toList();
    }

//    @Override
//    public Company findById(Long id) {
//       return companyRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Not found company with that id" + id));
//    }

    @Override
    public CompanyResponseDTO getCompaniesDetailById(UUID companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RecordNotFoundException("Not found company with id: " + companyId));
        return companyMapper.toCompanyResponseDTO(company);
    }

    @Override
    @Transactional
    public CompanyResponseDTO save(CompanyCreateRequestDTO createRequest) {
        Company company = companyMapper.convertCompanyRequestToCompany(createRequest);

        company.setCreated_by("company");
        company.setUpdated_by("company");
        company.setCreated_at(new Date());
        company.setUpdated_at(new Date());

        log.info("Saving company: " + company);
        Company savedCompany = companyRepository.save(company);
        return companyMapper.toCompanyResponseDTO(savedCompany);
    }

    @Override
    @Transactional
    public CompanyResponseDTO update(UUID id, CompanyUpdateRequestDTO request) {
        log.info("Request to update Company with ID: {}", id);

        Company existingCompany =  companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found company with id: " + id));

        companyMapper.updateCompanyFromDTO(request, existingCompany);

        Company updatedCompany = companyRepository.save(existingCompany);

        return companyMapper.toCompanyResponseDTO(updatedCompany);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        log.info("Request to delete Company with ID: {}", id);

        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found with id: " + id);
        }

        companyRepository.deleteById(id);
        log.info("Company deleted successfully.");

    }
}
