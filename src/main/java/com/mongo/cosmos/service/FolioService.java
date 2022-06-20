package com.mongo.cosmos.service;

import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.repository.FolioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FolioService {

    private final FolioRepository folioRepository;

    private final MongoTemplate configurationMongoTemplate;

    public void insertFolio(Folio folio){
        //buscar por producto
        Optional<Folio> folioOptional
                = folioRepository
                .findByProductAndAllyIdAndGatewayId(folio.getProduct(), folio.getAllyId(), folio.getGatewayId());
        //folio.setFolio(folio.getFolio()+1);
        // si el folio existe pues se actualiza
        if (folioOptional.isPresent()) {
            folioOptional.get().setFolio(folio.getFolio()+1);
            log.info("folio updated");
        }else {
            //si el folio no existe se guarda;
            folio.setFolio(1);
//            folioRepository.save(folio);
            configurationMongoTemplate.insert(folio, "folio");
            log.info("folio inserted");
        }
    }

}
