package com.mongo.cosmos.repository.persistencerepository;

import com.mongo.cosmos.model.AlaAzul;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlaAzulRepository extends MongoRepository<AlaAzul, String> {

    Optional<AlaAzul> findByProduct(String product);
    Optional<AlaAzul> findByConfigurator(Object configurator);
}
