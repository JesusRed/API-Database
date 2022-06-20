package com.mongo.cosmos.controller;

import com.mongo.cosmos.model.AlaAzul;
import com.mongo.cosmos.service.AlaAzulService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alaazul")
@RequiredArgsConstructor
public class AlaAzulController {
    private final AlaAzulService alaAzulService;

    @PostMapping("/new")
    public ResponseEntity<AlaAzul> saveAlaAzul(@RequestBody AlaAzul alaAzul){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alaAzulService.saveAlaAzul(alaAzul));
    }
}
