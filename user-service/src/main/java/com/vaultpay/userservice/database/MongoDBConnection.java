package com.vaultpay.userservice.database;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.BsonDocument;
import org.springframework.context.annotation.Bean;

public class MongoDBConnection {

    @Bean 
    public static MongoClient createMongoClient(){
        String uri = "mongodb+srv://vaultpay-cluster.kljyirt.mongodb.net/?authSource=%24external" +
                "&authMechanism=MONGODB-X509" +
                "&retryWrites=true" +
                "&w=majority" +
                "&appName=vaultpay-cluster" +
                "&tlsCertificateKeyFile=${MONGO_CERT_PATH}";
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("vaultpay_users");
        MongoCollection<Document> collection = database.getCollection("users");
        BsonDocument filter = new BsonDocument();
        collection.countDocuments(filter);

        mongoClient.close();
        return mongoClient;
    }
}