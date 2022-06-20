package com.mongo.cosmos.repository;

import com.mongo.cosmos.model.Configurator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfiguratorRepository extends MongoRepository<Configurator, String> {
    Optional<Configurator>  findByProductAndAllyIdAndGatewayId(String product, String allyId, String gatewayId);
}
