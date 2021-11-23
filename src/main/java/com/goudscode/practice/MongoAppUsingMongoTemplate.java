package com.goudscode.practice;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.goudscode.documents.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.MongoClients;

import java.util.List;

public class MongoAppUsingMongoTemplate {

    private static final Log log = LogFactory.getLog(MongoAppUsingMongoTemplate.class);

    public static void main(String[] args) {

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "tp");
        mongoOps.insert(new Person("Joe", 34));
        mongoOps.insertAll(List.of(new Person("Swati", 23), new Person("Pravin", 5)));

        log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));

        mongoOps.dropCollection("person");
    }
}