package com.chemical.services.implementations;

import com.chemical.dto.request.BranchCreateRequestDTO;
import com.chemical.dto.request.BranchUpdateResponseDTO;
import com.chemical.dto.response.BranchResponseDTO;
import com.chemical.entity.Branch;
import com.chemical.entity.Company;
import com.chemical.mapper.BranchMapper;
import com.chemical.repositories.BranchRepository;
import com.chemical.repositories.CompanyRepository;
import com.chemical.services.BranchService;
import com.chemical.services.CompanyService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BranchServiceImplementation implements BranchService {

    BranchRepository branchRepository;
    CompanyRepository companyRepository;
    BranchMapper branchMapper;

    @Override
    @Transactional
    public BranchResponseDTO save(BranchCreateRequestDTO request) {
        log.info("Request to create new Branch: {}", request.getName());

        Company company = companyRepository.findById(request.getCompanyId()).orElseThrow(() -> new RuntimeException("Company not found with this id: " + request.getCompanyId()));

        Branch branch = branchMapper.toBranch(request);

        branch.setCompany(company);

        return branchMapper.toBranchResponseDTO(branchRepository.save(branch));
    }

    @Override
    @Transactional
    public BranchResponseDTO update(UUID id, BranchUpdateResponseDTO request){
        log.info("Request to update Branch with id: {}", id);

        Branch existingBranch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found with id: " + id));

        if (request.getCompanyId() != null) {
            Company company = companyRepository.findById(request.getCompanyId()).orElseThrow(() -> new RuntimeException("Branch not found with this id: " + id));
            existingBranch.setCompany(company);
        }

        branchMapper.updateBranch(existingBranch, request);

        return branchMapper.toBranchResponseDTO(branchRepository.save(existingBranch));

    }

    @Override
    @Transactional
    public void delete(UUID id) {
        log.info("Request to delete Branch with id: {}", id);

        if (!branchRepository.existsById(id)) {
            throw new RuntimeException("Branch not found with this id: " + id);
        }

        companyRepository.deleteById(id);
        log.info("Branch with id: {} deleted", id);
    }



}
