package tech.bts.profeatweb.repository;

import com.mongodb.client.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import tech.bts.profeatweb.data.Meal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import tech.bts.profeatweb.data.Restaurant;
import tech.bts.profeatweb.examples.MongoUtil;

import javax.validation.constraints.Null;

import static tech.bts.profeatweb.examples.MongoUtil.doc;

@Repository
public class MealRepositoryMongo implements MealRepository{

    private MongoCollection<Document> meals;

    public MealRepositoryMongo() {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("profeat");
        this.meals = database.getCollection("meals");
    }

    public void create(Meal meal) {
        Document mealDoc = doc()
                .append("name", meal.getName())
                .append("price", meal.getPrice())
                .append("rate", meal.getRate())
                .append("restaurant", meal.getRestaurant())
                .append("type", meal.getTypeOfDish());
        meals.insertOne(mealDoc);
        // TODO: How to add maps to a database?
    }

    public Meal getById(Long id) {
        Document query = doc("_id", id);
        MongoCursor<Document> mealsCursor = meals.find(query).iterator();
        return getMeal(mealsCursor);
    }

    private Meal getMeal(MongoCursor<Document> mealsCursor) {
        Document mealFromDb = mealsCursor.next();
        Meal meal = new Meal(
                mealFromDb.getString("name"),
                mealFromDb.getDouble("price"),
                mealFromDb.getInteger("rate"),
                (Restaurant) mealFromDb.get("restaurant"),
                (Meal.DishType) mealFromDb.get("type")
        );

        System.out.println(meal.getName() + " " + meal.getPrice());

        mealsCursor.close();
        return meal;
    }

    public Collection<Meal> getAll() {
        MongoCursor<Document> mealsCursor = meals.find().iterator();
        List<Meal> meals = new ArrayList<>();
        while (mealsCursor.hasNext()){
            meals.add(getMeal(mealsCursor));
        }
        return meals;
    }

    public void update(Meal meal) {
        Document query = doc("_id", meal.getId());
        Document updates = doc("$set", doc("price", 10));
        // TODO: How to update all the fields of a meal
        meals.findOneAndUpdate(query, updates);
    }

    public void remove(Meal meal) {
        meals.findOneAndDelete(doc("_id", meal.getId()));
    }
}
