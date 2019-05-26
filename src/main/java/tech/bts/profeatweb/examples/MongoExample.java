package tech.bts.profeatweb.examples;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import tech.bts.profeatweb.data.Meal;
import tech.bts.profeatweb.data.Restaurant;
import tech.bts.profeatweb.repository.MealRepositoryMongo;

import static tech.bts.profeatweb.examples.MongoUtil.*;

public class MongoExample {

    public static void main(String[] args) {

        //Creates a client and connects to the server (by default, local server)
        //MongoClient mongoClient = MongoClients.create();

        //Here we get the database
        //MongoDatabase database = mongoClient.getDatabase("test");

        //Get a collection (table)
        //MongoCollection<Document> meals = database.getCollection("meals");

        /*Document newMeal = new Document().append("name", "fondue").append("price", 10.50).append("available", false);
        meals.insertOne(newMeal);

        // {name: "whatever"}
        //Document query = new Document("name", "whatever");
        Document query = new Document("_id", new ObjectId("5ca1c9a96cfbf0e550e5c8bc"));
        // {$set: {price: 11.0}} -> Every {} is a Document in Java
        Document updates = new Document("$set", new Document("price", 9.0));
        meals.updateOne(query, updates);*/

        /*Document query = doc("price", new Document("$gt", 10.0));

        MongoCursor<Document> mealsCursor = meals.find(query).iterator();
        while (mealsCursor.hasNext()) {
            Document meal = mealsCursor.next();
            String name = meal.getString("name");
            Double price = meal.getDouble("price");
            Boolean available = meal.getBoolean("available");

            System.out.println(name + " " + price + " " + available);
        }



        mealsCursor.close();*/

        /*MealRepositoryMongo mealRepo = new MealRepositoryMongo();

        Meal meal1 = new Meal("Paella", 12, 5, new Restaurant(), Meal.DishType.MAIN);
        Meal meal2 = new Meal("Sushi", 18.5, 4, new Restaurant(), Meal.DishType.STARTER);
        Meal meal3 = new Meal("Salad", 8.9, 3, new Restaurant(), Meal.DishType.STARTER);
        Meal meal4 = new Meal("Paella", 12, 5, new Restaurant(), Meal.DishType.MAIN);

        mealRepo.create(meal1);
        mealRepo.create(meal2);
        mealRepo.create(meal3);
        mealRepo.create(meal4);

        System.out.println(meal1.getId());
        System.out.println(meal2.getId());
        System.out.println(meal3.getId());
        System.out.println(meal4.getId());*/
    }
}
