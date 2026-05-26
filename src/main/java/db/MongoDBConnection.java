package db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void connect() {
        mongoClient = MongoClients.create("mongodb://localhost:30001/?directConnection=true");
        database = mongoClient.getDatabase("accounting");
    }

    public static MongoDatabase getDatabase() {
        if (database == null) {
            connect();
        }
        return database;
    }

    public static void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
