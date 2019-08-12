package com.arishenk;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MongoDBConnector {
    public static void main(String[] args) throws IOException {
        // присоединение
        FileInputStream fis;
        Properties prop = new Properties();
        fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);
        MongoClient mongoClient = MongoClients.create(prop.getProperty("host"));
        MongoDatabase db = mongoClient.getDatabase(prop.getProperty("dbname"));
        MongoCollection<Document> table = db.getCollection(prop.getProperty("table"));

        List<Document> list = new ArrayList<>();
        // создание записи
        Document doc = new Document("name", "Ivan")
                .append("phone", "900")
                .append("lang", Arrays.asList("java", "c++"));
        list.add(doc);

        doc = new Document("name", "Arina")
                .append("phone", "800")
                .append("lang", Arrays.asList("java", "c#"));
        list.add(doc);

        doc = new Document("name", "Masha")
                .append("phone", "700")
                .append("lang", Arrays.asList("javaScript", "c++"));
        list.add(doc);

        table.insertMany(list); // table.insertMany(userList);

        // получение одной записи
        Document myDoc = table.find().first();
        assert myDoc != null;
        System.out.println(myDoc.toJson());

        // получение всех записей
        for (Document cur : table.find()) {
            System.out.println(cur.toJson());
        }

        // обновление записи
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append("phone", "110"));
        BasicDBObject searchQuery = new BasicDBObject().append("name", "Ivan");
        table.updateOne(searchQuery, newDocument);

        // удаление записи
        table.deleteOne(searchQuery);
    }
}