package com.mongo.cosmos.repository;

import com.mongo.cosmos.model.Folio;
import com.mongo.cosmos.model.FormularioVista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolioRepository extends MongoRepository<Folio, String> {
    public Optional<Folio> findByProductAndAllyIdAndGatewayId(String product, String allyId, String gatewayId);
}
