package com.mongo.cosmos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document("AlaAzul")
public class AlaAzul {
    @Field(name = "_id")
    private String id;
    private String product;
    private String allyId;
    private String gatewayId;
    private int folio;
    private Object configurator;
    private Object user;
    private Object policy;
    private Object issueJson;
}
