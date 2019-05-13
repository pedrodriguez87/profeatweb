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
                .append("rate", meal.getRate());
                //.append("restaurant", meal.getRestaurant())
                //.append("type", meal.getTypeOfDish());
        meals.insertOne(mealDoc);
        setIdByName(meal);
        // TODO: How to add maps to a database? Id?
    }

    public Meal getById(Long id) {
        Document query = doc("_id", id);
        MongoCursor<Document> mealsCursor = meals.find(query).iterator();
        Meal meal = getMeal(mealsCursor);

        mealsCursor.close();
        return meal;

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

        return meal;
    }

    public Collection<Meal> getAll() {
        MongoCursor<Document> mealsCursor = meals.find().iterator();
        List<Meal> meals = new ArrayList<>();
        while (mealsCursor.hasNext()){
            meals.add(getMeal(mealsCursor));
        }
        mealsCursor.close();
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

    private void setIdByName(Meal meal) {
        String value = '"' + meal.getName() + '"';
        Document query = doc("name", value);
        MongoCursor<Document> mealsCursor = meals.find(query).iterator();
        while (mealsCursor.hasNext()) {
            Document mealFromDb = mealsCursor.next();
            ObjectId id = mealFromDb.getObjectId("_id");
            meal.setId(mealFromDb.get("_id", ObjectId.class).toString());
        }
        /*Meal meal = new Meal(
                mealFromDb.getString("name"),
                mealFromDb.getDouble("price"),
                mealFromDb.getInteger("rate"),
                (Restaurant) mealFromDb.get("restaurant"),
                (Meal.DishType) mealFromDb.get("type")
        );
        meal.setId(mealFromDb.getObjectId("_id").toString());*/

        mealsCursor.close();
        //return mealFromDb.get("_id", ObjectId.class).toString();
    }
}
