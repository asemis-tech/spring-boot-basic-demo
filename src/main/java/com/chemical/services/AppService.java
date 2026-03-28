package com.chemical.services;

import com.chemical.dto.request.AppCreateRequestDTO;
import com.chemical.dto.response.AppResponseDTO;
import com.chemical.entity.App;
import org.springframework.stereotype.Service;

@Service
public interface AppService {
    App save(AppCreateRequestDTO request);
}
