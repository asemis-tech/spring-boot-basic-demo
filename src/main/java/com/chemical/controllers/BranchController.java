package com.chemical.controllers;

import com.chemical.common.BaseResponse;
import com.chemical.dto.request.BranchCreateRequestDTO;
import com.chemical.dto.request.BranchUpdateResponseDTO;
import com.chemical.dto.response.BranchResponseDTO;
import com.chemical.repositories.BranchRepository;
import com.chemical.services.BranchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@Tag(name = "Branch Controller")
@RestController
@RequestMapping("/api/branch")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @Operation(summary = "Create a new branch")
    @PostMapping
    public BaseResponse<BranchResponseDTO> createBranch(@RequestBody BranchCreateRequestDTO request) {
        log.info("REST request to save Branch: {}", request.getName());
        BranchResponseDTO createdBranch = branchService.save(request);
        return BaseResponse.ok(createdBranch);
    }

    @Operation(summary = "Update an existing Branch")
    @PutMapping("/{id}")
    public BaseResponse<BranchResponseDTO> updateBranch(@PathVariable("id") UUID id, @RequestBody BranchUpdateResponseDTO request) {
        log.info("REST request to update Branch : {}", id);

        BranchResponseDTO updatedBranch = branchService.update(id, request);

        return BaseResponse.ok(updatedBranch);
    }

    @Operation(summary = "Delete an existing Branch")
    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteBranch(@PathVariable("id") UUID id) {
        log.info("REST request to delete Branch : {}", id);

        branchService.delete(id);
        return BaseResponse.ok(null);
    }
}
