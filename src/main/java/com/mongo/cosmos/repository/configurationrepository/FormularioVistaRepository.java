package com.mongo.cosmos.repository.configurationrepository;

import com.mongo.cosmos.model.FormularioVista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormularioVistaRepository extends MongoRepository<FormularioVista, String> {
    Optional<FormularioVista> findByName(String name);
}
