package com.mongo.cosmos.service;

import com.mongo.cosmos.model.AlaAzul;
import com.mongo.cosmos.model.Configurator;
import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.repository.AlaAzulRepository;
import com.mongo.cosmos.repository.ConfiguratorRepository;
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
    private final AlaAzulRepository alaAzulRepository;

    public AlaAzul saveAlaAzul(@RequestBody AlaAzul alaAzul) {
        //buscar la id compuesta en configurator
        Optional<Configurator> configuratorOptional = configuratorRepository
                .findByProductAndAllyIdAndGatewayId(
                        alaAzul.getProduct(), alaAzul.getAllyId(), alaAzul.getGatewayId()
                );
        // si existe el configurador se crea el folio
        if (configuratorOptional.isPresent()) {
            //inserta el folio
            Folio folio = new Folio();
            folio.setProduct(alaAzul.getProduct());
            folio.setAllyId(alaAzul.getAllyId());
            folio.setGatewayId(alaAzul.getGatewayId());
            folioService.insertFolio(folio);
            // añade la configuracion a alaazul
            alaAzul.setConfigurator(configuratorOptional);
            // añade el folio a la alaazul
            alaAzul.setFolio(folio.getFolio());
            alaAzulRepository.save(alaAzul);
        }else {
            //error 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Configuration not found");
        }
        return alaAzul;
    }
}
