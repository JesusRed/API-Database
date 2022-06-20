package com.mongo.cosmos.repository;

import com.mongo.cosmos.model.FormularioVista;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FormularioVistaRepository extends MongoRepository<FormularioVista, String> {
    public Optional<FormularioVista> findByName(String name);
}
