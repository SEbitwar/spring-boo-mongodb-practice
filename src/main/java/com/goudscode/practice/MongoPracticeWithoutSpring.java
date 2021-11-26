package com.goudscode.practice;

import com.mongodb.client.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.Document;

public class MongoPracticeWithoutSpring {

    private static final Log log = LogFactory.getLog(MongoPracticeWithoutSpring.class);

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase moviesDB = mongoClient.getDatabase("movies");
        MongoCollection<Document> moviesInfoCollection = moviesDB.getCollection("moviesInfo");

        FindIterable<Document> documents = moviesInfoCollection.find();

        for (Document d : documents)
            System.out.println(d.toJson());

    }
}