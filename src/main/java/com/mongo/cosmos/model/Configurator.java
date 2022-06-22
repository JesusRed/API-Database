package com.mongo.cosmos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document("configurator")
public class Configurator {
    @Id
    @Field(name = "_id")
    private String _id;
    private String product;
    private String allyId;
    private String gatewayId;
    private Object general;
    private Object theme;
    private Object steps;
}
