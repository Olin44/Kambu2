package com.example.project;

import com.mongodb.*;


class MongoDB {
    static void saveToDb(String class_name, String date) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("logs_db");
        DBObject log = new BasicDBObject(class_name, date);
        DBCollection collection = database.getCollection("logs");
        collection.insert(log);
    }
}
