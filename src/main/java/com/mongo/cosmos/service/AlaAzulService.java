package com.mongo.cosmos.service;

import com.mongo.cosmos.model.AlaAzul;
import com.mongo.cosmos.model.Configurator;
import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.repository.configurationrepository.ConfiguratorRepository;
import com.mongo.cosmos.repository.configurationrepository.FolioRepository;
import com.mongo.cosmos.repository.persistencerepository.AlaAzulRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class AlaAzulService {


    private final ConfiguratorRepository configuratorRepository;
    private final FolioService folioService;
    private final FolioRepository folioRepository;
    private final AlaAzulRepository alaAzulRepository;
    private final MongoTemplate persistenceMongoTemplate;

    public Folio saveAlaAzul(@RequestBody AlaAzul persistence) {
        Optional<AlaAzul> alaAzulOptional = alaAzulRepository.findByConfigurator(persistence.getConfigurator());
        // validar que si exista y ese existente tenga configurator
        if (alaAzulOptional.isPresent()) {
            //error 404
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Collection exists");
        } else {
            //buscar la id compuesta en configurator
            Optional<Configurator> configuratorOptional = configuratorRepository.findByProductAndAllyIdAndGatewayId(persistence.getProduct(), persistence.getAllyId(), persistence.getGatewayId());
            // si existe el configurador se crea el folio
            if (configuratorOptional.isEmpty()) {
                //error 400
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Configuration not found");
            }
            //inserta el configurator
            persistence.setConfigurator(configuratorOptional.get());
            //busca el folio
            Optional<Folio> folio1 = folioRepository.findByProductAndAllyIdAndGatewayId(persistence.getProduct(), persistence.getAllyId(), persistence.getGatewayId());
            Folio f = new Folio();
            f.setProduct(persistence.getProduct());
            f.setAllyId(persistence.getAllyId());
            f.setGatewayId(persistence.getGatewayId());
            if (folio1.isEmpty()) {
                folioService.newFolio(f);
                f.setFolio(1);
                //se inserta el folio en el alaazul
                persistence.setFolio(1);
                return f;
            }
            persistence.setFolio(folio1.get().getFolio());
            //guarda la coleccion
            alaAzulRepository.save(persistence);
            //persistenceMongoTemplate.insert()
            //qwerty.save(persistence, persistence.getProduct());
            return folio1.get();
        }
    }

    public AlaAzul getAlaAzul(String allyId, String product, String gatewayId, int folio) {
        Optional<AlaAzul> alaAzulOptional = alaAzulRepository.findByAllyIdAndProductAndGatewayIdAndFolio(allyId, product, gatewayId, folio);
        if (alaAzulOptional.isPresent()) {
            log.info("searching persistence: {}", alaAzulOptional.get());
            return alaAzulOptional.get();
        }
        log.info("persistence not found");
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persistence not found");
    }

}
