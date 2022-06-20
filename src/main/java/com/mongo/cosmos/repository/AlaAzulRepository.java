package com.mongo.cosmos.repository;

import com.mongo.cosmos.model.AlaAzul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlaAzulRepository extends MongoRepository<AlaAzul, String> {

    Optional<AlaAzul> findByProduct(String product);
}
