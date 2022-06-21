package com.mongo.cosmos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.mongo.cosmos.repository.persistencerepository"}, mongoTemplateRef = PersistenceDBConfig.MONGO_TEMPLATE)
public class PersistenceDBConfig {
    protected static final String MONGO_TEMPLATE = "persistencedbMongoTemplate";
}
