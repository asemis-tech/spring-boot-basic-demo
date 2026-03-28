package com.chemical.services.implementations;

import com.chemical.dto.request.AppCreateRequestDTO;
import com.chemical.entity.App;
import com.chemical.mapper.AppMapper;
import com.chemical.repositories.AppRepository;
import com.chemical.services.AppService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppServiceImplementation implements AppService {
    AppRepository appRepository;
    AppMapper appMapper;

    @Override
    @Transactional
    public App save(AppCreateRequestDTO request) {
        App app = appMapper.appCreateRequestConvertToApp(request);

        app.setCreated_by("app");
        app.setUpdated_by("app");
        app.setCreated_at(new Date());
        app.setUpdated_at(new Date());

        return appRepository.save(app);

    }
}
