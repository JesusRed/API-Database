package com.mongo.cosmos.repository;

import com.mongo.cosmos.model.AlaAzul;
import com.mongo.cosmos.model.FormularioVista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlaAzulRepository extends MongoRepository<AlaAzul, String> {

}
