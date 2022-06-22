package com.mongo.cosmos.repository.configurationrepository;

import com.mongo.cosmos.model.Folio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolioRepository extends MongoRepository<Folio, String> {
    Optional<Folio> findByProductAndAllyIdAndGatewayId(String product, String allyId, String gatewayId);

}
