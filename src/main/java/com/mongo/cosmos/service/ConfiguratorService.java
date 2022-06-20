package com.mongo.cosmos.service;

import com.mongo.cosmos.model.Configurator;
import com.mongo.cosmos.repository.ConfiguratorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfiguratorService {

    private final ConfiguratorRepository configuratorRepository;


    private final MongoTemplate configurationMongoTemplate;

    public Configurator createConfigurator(Configurator configurator){
        // falta validación
        return configurationMongoTemplate.insert(configurator, "configurator");
    }
}
