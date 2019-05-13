package tech.bts.profeatweb.repository;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import tech.bts.profeatweb.data.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static tech.bts.profeatweb.examples.MongoUtil.doc;

@Repository
public class UserRepositoryMongo implements UserRepository{

    private MongoCollection<Document> users;

    public UserRepositoryMongo() {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("profeat");
        this.users = database.getCollection("users");
    }

    public void create(User user) {
        Document mealDoc = doc()
                .append("email", user.getEmail())
                .append("password", user.getPassword());
        users.insertOne(mealDoc);
        setIdByEmail(user);
        // TODO: How to add maps to a database? Id?
    }

    public User getById(String id) {
        Document query = doc("_id", id);
        MongoCursor<Document> usersCursor = users.find(query).iterator();

        User user = getUser(usersCursor);
        usersCursor.close();

        return user;
    }

    private User getUser(MongoCursor<Document> usersCursor) {
        Document userFromDb = usersCursor.next();
        User user = new User(
                userFromDb.getString("email"),
                userFromDb.getString("password"),
                userFromDb.get("_id", Object.class).toString()
        );


        System.out.println(user.getEmail() + " " + user.getPassword());

        return user;
    }

    public Collection<User> getAll() {
        MongoCursor<Document> usersCursor = users.find().iterator();
        List<User> users = new ArrayList<>();
        while (usersCursor.hasNext()){
            users.add(getUser(usersCursor));
        }
        usersCursor.close();
        return users;
    }

    public void update(User user) {
        Document query = doc("_id", user.getId());
        Document updates = doc("$set", doc("email", "email@email.com"));
        // TODO: How to update all the fields of a user (append)
        users.findOneAndUpdate(query, updates);
    }

    public void remove(User user) {
        users.findOneAndDelete(doc("_id", user.getId()));
    }

    @Override
    public boolean login(User user) {
        boolean validation = false;
        MongoCursor<Document> usersCursor = users.find().iterator();
        while (usersCursor.hasNext()) {
            User userInDb = getUser(usersCursor);
            if (userInDb.getEmail().equals(user.getEmail()) && userInDb.getPassword().equals(user.getPassword())) {
                validation = true;
            }
        }

        return validation;
    }

    private void setIdByEmail(User user) {
        String value = '"' + user.getEmail() + '"';
        Document query = doc("email", value);
        MongoCursor<Document> usersCursor = users.find(query).iterator();
        while (usersCursor.hasNext()) {
            Document userFromDb = usersCursor.next();
            ObjectId id = userFromDb.getObjectId("_id");
            user.setId(userFromDb.get("_id", ObjectId.class).toString());
        }
        usersCursor.close();
    }

}
