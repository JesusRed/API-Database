package com.mongo.cosmos.service;

import com.mongo.cosmos.model.Configurator;
import com.mongo.cosmos.repository.configurationrepository.ConfiguratorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfiguratorService {

    private final ConfiguratorRepository configuratorRepository;


    public Configurator createConfigurator(Configurator configurator){
        // falta validación
        return configuratorRepository.save(configurator);
        //return configurationMongoTemplate.insert(configurator, "configurator");
    }
}
