package com.burhanmutlu.discributed;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscributedApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscributedApplication.class, args);


		/*ConnectionString connectionString =
				new ConnectionString("mongodb://localhost:27018,localhost:27019,localhost:27020/?replicaSet=myReplicaSet");
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		MongoClient mongoClient = MongoClients.create(settings);

		MongoDatabase database = mongoClient.getDatabase("demo");

		MongoCollection<Document> collection = database.getCollection("users");

		Document document = new Document("username", "burhack")
				.append("name", "burhan");
		collection.insertOne(document);

		mongoClient.close();*/

	}

}
