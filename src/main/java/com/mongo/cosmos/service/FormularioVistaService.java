package com.mongo.cosmos.service;

import com.mongo.cosmos.model.FormularioVista;
import com.mongo.cosmos.repository.FormularioVistaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormularioVistaService {

    private final FormularioVistaRepository formularioVistaRepository;

    public List<FormularioVista> getAllFormularioVista(){
        log.info("Showing all collections from FormularioVista");
        return formularioVistaRepository.findAll();
        //throw new  ResponseStatusException(HttpStatus.OK, "List of FormularioVista");
    }

    public FormularioVista addFormularioVista(FormularioVista formularioVista){
        Optional<FormularioVista> formularioVistaOptional = formularioVistaRepository.findByName(formularioVista.getName());
        if (formularioVistaOptional.isPresent()){
            log.info("ERROR adding {} in a new collection to FormularioVista", formularioVista.getName());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "FormView exists");
        }
        log.info("Adding {} in a new collection to FormularioVista", formularioVista.getName());
        return formularioVistaRepository.save(formularioVista);
    }


}