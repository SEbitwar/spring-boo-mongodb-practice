package com.goudscode;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringBootMongodbPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbPracticeApplication.class, args);
	}

	@Bean
	MongoTemplate mongoTemplate() {
		return new MongoTemplate(MongoClients.create("mongodb://localhost:27017"), "spring_practice");
	}

}
