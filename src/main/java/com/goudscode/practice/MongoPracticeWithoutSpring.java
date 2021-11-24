package com.goudscode.practice;

import com.goudscode.documents.Person;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;

import java.util.List;
import java.util.Set;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class MongoPracticeWithoutSpring {

    private static final Log log = LogFactory.getLog(MongoPracticeWithoutSpring.class);

    public static void main(String[] args) {

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "mongo_practice");

        mongoOps.insertAll(List.of(new Person("Sainath", 24), new Person("Priyanka", 38)));

        Person obj1 = mongoOps.findOne(query(where("name").is("Sainath")), Person.class);

        Person obj2 = mongoOps.findOne(query(where("name").is("Sainath")), Person.class);

        obj2.setName("Sai");

        mongoOps.save(obj2);
        mongoOps.query(Person.class)
                .matching(where("").is(""));
        mongoOps.save(obj1);

        mongoOps.dropCollection("person");
    }
}