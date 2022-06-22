package com.mongo.cosmos.service;

import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.repository.configurationrepository.FolioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FolioService {

    private final FolioRepository folioRepository;

    public Folio updateFolio(Folio folio) {
        Optional<Folio> f = folioRepository.findByProductAndAllyIdAndGatewayId(folio.getProduct(), folio.getAllyId(), folio.getGatewayId());
        if (f.isPresent()) {
            f.get().setFolio(f.get().getFolio()+1);
            log.info("folio updated {}: ", f);
            return folioRepository.save(f.get());
        }
        folio.setFolio(1);
        log.info("folio saved");
        return folioRepository.save(folio);
    }
}

