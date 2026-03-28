package com.chemical.mapper;

import com.chemical.dto.request.AppCreateRequestDTO;
import com.chemical.dto.response.AppResponseDTO;
import com.chemical.entity.App;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AppMapper {
    AppResponseDTO toAppResponseDTO(App app);
    App appCreateRequestConvertToApp(AppCreateRequestDTO request);
}
