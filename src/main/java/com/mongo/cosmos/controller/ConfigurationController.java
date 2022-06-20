package com.mongo.cosmos.controller;

import com.mongo.cosmos.model.Configurator;
import com.mongo.cosmos.service.ConfiguratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configurator")
@RequiredArgsConstructor
public class ConfigurationController {
    private final ConfiguratorService configuratorService;

    @PostMapping("/add")
    public ResponseEntity<Configurator> createConfigurator(@RequestBody Configurator configurator) {
        return ResponseEntity.status(HttpStatus.CREATED).body(configuratorService.createConfigurator(configurator));
    }
}
