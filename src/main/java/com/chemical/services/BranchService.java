package com.chemical.services;

import com.chemical.dto.request.BranchCreateRequestDTO;
import com.chemical.dto.request.BranchUpdateResponseDTO;
import com.chemical.dto.response.BranchResponseDTO;
import com.chemical.entity.Branch;

import java.util.UUID;

public interface BranchService {
    BranchResponseDTO save(BranchCreateRequestDTO request);
    BranchResponseDTO update(UUID id, BranchUpdateResponseDTO request);

    void delete(UUID id);
}
