package com.mongo.cosmos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document("AlaAzul")
public class AlaAzul {
    private String _id;
    private String product;
    private String allyId;
    private String gatewayId;
    private int folio;
    private Object configurator;
    private Object user;
    private Object policy;
    private Object issueJson;
}
