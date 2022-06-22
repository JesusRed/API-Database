package com.mongo.cosmos.service;

import com.mongo.cosmos.model.AlaAzul;
import com.mongo.cosmos.model.Configurator;
import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.repository.configurationrepository.ConfiguratorRepository;
import com.mongo.cosmos.repository.configurationrepository.FolioRepository;
import com.mongo.cosmos.repository.persistencerepository.AlaAzulRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    //private final MongoTemplate persistenceMongoTemplate;

    public AlaAzul saveAlaAzul(@RequestBody AlaAzul alaAzul) {
        Optional<AlaAzul> alaAzulOptional = alaAzulRepository.findByConfigurator(alaAzul.getConfigurator());
        // validar que si exista y ese existente tenga configurator
        if (alaAzulOptional.isPresent()) {
            //error 404
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Collection exists");
        } else {
            //buscar la id compuesta en configurator
            Optional<Configurator> configuratorOptional = configuratorRepository.findByProductAndAllyIdAndGatewayId(alaAzul.getProduct(), alaAzul.getAllyId(), alaAzul.getGatewayId());
            // si existe el configurador se crea el folio
            if (configuratorOptional.isEmpty()) {
                //error 400
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Configuration not found");
            }
            //inserta el configurator
            alaAzul.setConfigurator(configuratorOptional.get());
            //crea el folio
            Optional<Folio> folioOptional = folioRepository.findByProductAndAllyIdAndGatewayId(alaAzul.getProduct(), alaAzul.getAllyId(), alaAzul.getGatewayId());
            if (folioOptional.isPresent()) {
                //se actualiza en el folio en el alaazul
                alaAzul.setFolio(folioOptional.get().getFolio());
                //se hace +1 en el folio registrado

                //guarda la coleccion
                alaAzulRepository.save(alaAzul);
            }
            //crea el folio
            Folio f = new Folio();
            f.setProduct(alaAzul.getProduct());
            f.setAllyId(alaAzul.getAllyId());
            f.setGatewayId(alaAzul.getGatewayId());

            //se inserta 1 en el alaazul
            alaAzul.setFolio(1);
            //guarda la coleccion
            alaAzulRepository.save(alaAzul);


            return alaAzul;
        }
    }
}
