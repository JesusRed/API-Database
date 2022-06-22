package com.mongo.cosmos.config;

import com.mongo.cosmos.model.AlaAzul;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MultipleMongoConfig {

    @Primary
    @Bean(name = "configurationdbProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.configurationdb")
    public MongoProperties getConfigurationDBProps() throws Exception {
        return new MongoProperties();
    }

    @Bean(name = "persistencedbProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.persistencedb")
    public MongoProperties getPersistenceDBProps() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "configurationdbMongoTemplate")
    public MongoTemplate configurationdbMongoTemplate() throws Exception {
        return new MongoTemplate(configurationdbMongoDatabaseFactory(getConfigurationDBProps()));
    }

    @Bean(name = "persistencedbMongoTemplate")
    public MongoTemplate persistencedbMongoTemplate() throws Exception {
        return new MongoTemplate(persistencedbMongoDatabaseFactory(getPersistenceDBProps()));
    }

    @Primary
    @Bean
    public MongoDatabaseFactory configurationdbMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory persistencedbMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
}
