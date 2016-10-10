package com.connection.MongoDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.connection.document.SimpleDocument;

@SpringBootApplication
public class ConnectionApplication implements CommandLineRunner{
	@Autowired
	MongoOperations mongoOperations;
	public static void main(String[] args) {
		SpringApplication.run(ConnectionApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		SimpleDocument simpleDocument = new SimpleDocument("2", "Komal");
		// save
		 mongoOperations.save(simpleDocument);
		 
		 
		// build mongo query
		 Query query = new Query(Criteria.where("name").is("Aparna"));
		 // search operation
		 SimpleDocument object = (SimpleDocument) mongoOperations.findOne(query, SimpleDocument.class);
		 System.out.println(object.toString());
		
		 // find all simple document in DB
		 List<SimpleDocument> objLst = mongoOperations.findAll(SimpleDocument.class);
		 System.out.println(objLst.toString());
		
	}
}
