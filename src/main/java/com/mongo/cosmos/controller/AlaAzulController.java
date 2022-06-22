package com.mongo.cosmos.controller;

import com.mongo.cosmos.model.AlaAzul;
import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.service.AlaAzulService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persistence")
@RequiredArgsConstructor
public class AlaAzulController {
    private final AlaAzulService alaAzulService;

    @PostMapping("/new")
    public ResponseEntity<Folio> saveAlaAzul(@RequestBody AlaAzul alaAzul){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alaAzulService.saveAlaAzul(alaAzul));
    }

    @GetMapping("/{allyId}/{product}/{gatewayId}/{folio}")
    public ResponseEntity<AlaAzul> getAlaAzul(@PathVariable String allyId,@PathVariable String product,@PathVariable String gatewayId, @PathVariable int folio){
        return ResponseEntity.status(HttpStatus.OK).body(alaAzulService.getAlaAzul(allyId, product, gatewayId, folio));
    }
}
