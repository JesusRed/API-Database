package com.mongo.cosmos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.mongo.cosmos.repository.configurationrepository"}, mongoTemplateRef = ConfigurationDBConfig.MONGO_TEMPLATE)
public class ConfigurationDBConfig {
    protected static final String MONGO_TEMPLATE = "configurationdbMongoTemplate";
}
