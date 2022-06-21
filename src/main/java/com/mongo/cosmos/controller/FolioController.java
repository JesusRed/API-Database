package com.mongo.cosmos.controller;

import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.service.FolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/folios")
@RequiredArgsConstructor
public class FolioController {

    private final FolioService folioService;

    @PostMapping("/add")
    public ResponseEntity<Folio> createFolio(@RequestBody Folio folio){
        //no puede recibir folio, crear un dto que reciba la llave compuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(folioService.updateFolio(folio));
    }
}
