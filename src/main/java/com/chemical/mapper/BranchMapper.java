package com.chemical.mapper;

import com.chemical.dto.request.BranchCreateRequestDTO;
import com.chemical.dto.request.BranchUpdateResponseDTO;
import com.chemical.dto.response.BranchResponseDTO;
import com.chemical.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BranchMapper {
    @Mapping(target = "company", ignore = true)
    Branch toBranch(BranchCreateRequestDTO dto);

    @Mapping(target = "company.id", ignore = true)
    BranchResponseDTO toBranchResponseDTO(Branch branch);

    @Mapping(target = "company.id", ignore = true)
    void updateBranch(@MappingTarget Branch branch, BranchUpdateResponseDTO request);
}
