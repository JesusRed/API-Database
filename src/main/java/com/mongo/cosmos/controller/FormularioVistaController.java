package com.mongo.cosmos.controller;

import com.azure.core.annotation.Post;
import com.mongo.cosmos.model.FormularioVista;
import com.mongo.cosmos.service.FormularioVistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/views")
@RequiredArgsConstructor
public class FormularioVistaController {

    private final FormularioVistaService formularioVistaService;

    @GetMapping("/all")
    public ResponseEntity<List<FormularioVista>> getAllFormularioVista() {
        return ResponseEntity.ok().body(formularioVistaService.getAllFormularioVista());
    }

    @PostMapping("/add")
    public ResponseEntity<FormularioVista> addFormularioVista(@Valid @RequestBody FormularioVista formularioVista){

    }

}
