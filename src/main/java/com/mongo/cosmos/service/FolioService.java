package com.mongo.cosmos.service;

import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.repository.configurationrepository.FolioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FolioService {

    private final FolioRepository folioRepository;

    public Folio updateFolio(Folio folio) {
        Folio folioOptional = folioRepository.findByProductAndAllyIdAndGatewayId(folio.getProduct(), folio.getAllyId(), folio.getGatewayId());
        if (folioOptional != null) {
            //Folio folioUpdated = folioRepository.save(folioOptional.get());
            folioOptional.setFolio(folioOptional.getFolio() + 1);
            log.info("folio updated {}: ", folioOptional);
            return folioRepository.save(folioOptional);
        }
        folio.setFolio(1);
        log.info("folio saved");
        return folioRepository.save(folio);
    }
}

