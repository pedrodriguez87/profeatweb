package tech.bts.profeatweb.examples;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import static tech.bts.profeatweb.examples.MongoUtil.*;

public class MongoExample {

    public static void main(String[] args) {

        //Creates a client and connects to the server (by default, local server)
        MongoClient mongoClient = MongoClients.create();

        //Here we get the database
        MongoDatabase database = mongoClient.getDatabase("test");

        //Get a collection (table)
        MongoCollection<Document> meals = database.getCollection("meals");

        /*Document newMeal = new Document().append("name", "fondue").append("price", 10.50).append("available", false);
        meals.insertOne(newMeal);

        // {name: "whatever"}
        //Document query = new Document("name", "whatever");
        Document query = new Document("_id", new ObjectId("5ca1c9a96cfbf0e550e5c8bc"));
        // {$set: {price: 11.0}} -> Every {} is a Document in Java
        Document updates = new Document("$set", new Document("price", 9.0));
        meals.updateOne(query, updates);*/

        Document query = doc("price", new Document("$gt", 10.0));

        MongoCursor<Document> mealsCursor = meals.find(query).iterator();
        while (mealsCursor.hasNext()) {
            Document meal = mealsCursor.next();
            String name = meal.getString("name");
            Double price = meal.getDouble("price");
            Boolean available = meal.getBoolean("available");

            System.out.println(name + " " + price + " " + available);
        }

        mealsCursor.close();
    }
}
