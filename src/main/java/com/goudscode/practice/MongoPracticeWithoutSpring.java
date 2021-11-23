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

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class MongoPracticeWithoutSpring {

    private static final Log log = LogFactory.getLog(MongoPracticeWithoutSpring.class);

    public static void main(String[] args) {

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "mongo_practice");

        mongoOps.insertAll(List.of(new Person("Sainath", 24), new Person("Priyanka", 38)));

        List<Person> personList = mongoOps.findAll(Person.class);

        List<Person> personList1 = mongoOps.find(query(where("age").lt(28)), Person.class);

        log.info("person list : " + personList);

        mongoOps.update(Person.class)
                .matching(Query.query(where("name").is("Swati")))
                .apply(Update.update("name", "Swati Patil"));
//                .


        mongoOps.dropCollection("person");
    }
}