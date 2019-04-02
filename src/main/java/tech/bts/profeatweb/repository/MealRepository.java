package tech.bts.profeatweb.repository;

import tech.bts.profeatweb.data.Meal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public interface MealRepository {

    void create(Meal meal);

    Meal getById(Long id);

    Collection<Meal> getAll();

    void update(Meal meal);

    void remove(Meal meal);
}
