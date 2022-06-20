package com.mongo.cosmos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document("configurator")
public class Configurator {
    private String product;
    private String allyId;
    private String gatewayId;
    private Object general;
    private Object theme;
    private Object steps;
}
