package com.mongo.cosmos.model;

import com.mongo.cosmos.model.FormularioVistaModel.Access;
import com.mongo.cosmos.model.FormularioVistaModel.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document("viewforms")
public class FormularioVista {
    @Id
    @Field(name = "_id")
    private String id;
    private String type;
    private Object tags;
    private String owner;
    private Object components;
    private String revisions;
    private int _vid;
    private String title;
    private String display;
    private Object access;
    private Object submissionAccess;
    private String controller;
    private Object properties;
    private Object settings;
    private String name;
    private String path;
    private String project;
    private LocalDateTime created;
    private String modified;
    private Object machineName;
}
