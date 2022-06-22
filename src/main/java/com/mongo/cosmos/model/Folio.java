package com.mongo.cosmos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document("folios")
@JsonIgnoreProperties(value = { "_id" })
public class Folio {
    @Id
    @Field(name = "_id")
    private ObjectId _id;
    private int folio;
    private String allyId;
    private String product;
    private String gatewayId;
}
