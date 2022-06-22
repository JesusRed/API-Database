package com.mongo.cosmos.service;

import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.repository.configurationrepository.FolioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FolioService {

    private final FolioRepository folioRepository;

    public Folio updateFolio(Folio folio) {
        Optional<Folio> f = folioRepository.findByProductAndAllyIdAndGatewayId(folio.getProduct(), folio.getAllyId(), folio.getGatewayId());
        if (f.isPresent()) {
            f.get().setFolio(f.get().getFolio() + 1);
            log.info("folio updated {}: ", f);
            return folioRepository.save(f.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Folio exists");
    }

    public Folio newFolio(Folio folio) {
        folio.setFolio(1);
        log.info("folio saved");
        return folioRepository.save(folio);
    }
}

