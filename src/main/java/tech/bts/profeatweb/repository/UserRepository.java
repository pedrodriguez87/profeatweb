package tech.bts.profeatweb.repository;

import tech.bts.profeatweb.data.Meal;
import tech.bts.profeatweb.data.User;

import java.util.Collection;

public interface UserRepository {

    void create(User user);

    User getById(String id);

    Collection<User> getAll();

    void update(User user);

    void remove(User user);

    boolean login(User user);
}
