package com.mongo.cosmos;

import com.mongo.cosmos.model.FormularioVista;
import com.mongo.cosmos.repository.FormularioVistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CosmosApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CosmosApplication.class, args);
    }

    @Autowired
    private FormularioVistaRepository formularioVistaRepository;

    @Override
    public void run(String... args) throws Exception {
        formularioVistaRepository.deleteAll();
        FormularioVista formularioVista = new FormularioVista();

        formularioVista.setType("form");
        List<Object> tagList = Arrays.asList("foo", "bar");
        formularioVista.setTags(tagList);
        formularioVista.setOwner("6273e3eda9510a9a9c7b7fd7");
        List<Object> buttonList = Arrays.asList("previous", "next", "cancel");
        List<Object> componentList = Arrays.asList("title", "breadcrumbclieckeable", buttonList);
        formularioVista.setComponents(componentList);
        formularioVista.setRevisions("revisions");
        formularioVista.set_vid(0);
        formularioVista.setTitle("formularioTest");
        formularioVista.setDisplay("magic");
        List<Object> accessList = Arrays.asList("roles", "type");
        formularioVista.setAccess(accessList);
        List<Object> submissionAccessList = Arrays.asList("submission", "access");
        formularioVista.setSubmissionAccess(submissionAccessList);
        formularioVista.setController("controller");
        formularioVista.setProperties("properties");
        formularioVista.setSettings("settings");
        formularioVista.setName("formularioTest");
        formularioVista.setPath("formularioTest");
        formularioVista.setProject("6279256f157c25ed6d665fa8");
        formularioVista.setCreated(LocalDateTime.now());
        formularioVista.setModified(LocalDateTime.now().toString());
        formularioVista.setMachineName("compound:key");
        formularioVistaRepository.save(formularioVista);
    }
}
