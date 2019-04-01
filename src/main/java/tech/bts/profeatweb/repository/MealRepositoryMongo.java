package tech.bts.profeatweb.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Repository;
import tech.bts.profeatweb.data.Meal;
import java.util.ArrayList;
import java.util.Collection;
import org.bson.Document;
import tech.bts.profeatweb.examples.MongoUtil;

@Repository
public class MealRepositoryMongo implements MealRepository{

    private MongoCollection<Document> meals;

    public MealRepositoryMongo() {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("profeat");
        this.meals = database.getCollection("meals");
    }

    public void create(Meal meal) {
        Document mealDoc = MongoUtil.doc()
                .append("name", meal.getName())
                .append("price", meal.getPrice())
                .append("vegs", meal.getHasvegetables())
                .append("rate", meal.getRate())
                .append("restaurant", meal.getRestaurant())
                .append("type", meal.getTypeofdish());
        meals.insertOne(mealDoc);
    }

    public Meal getById(Long id) {
        return new Meal();
    }

    public Collection<Meal> getAll() {
        return new ArrayList<>();
    }
}
