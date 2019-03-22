package repository;
import data.Meal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MealRepository {

    private Map<Long, Meal> mealMap;
    private long nextId;

    public MealRepository() {
        mealMap = new HashMap<>();
        nextId = 0;
    }

    public void create(Meal meal) {
        meal.setId(nextId);
        mealMap.put(meal.getId(), meal);
        nextId++;
    }

    public Meal getById(Long id) {
        return mealMap.get(id);

    }

    public Collection<Meal> getAll() {
        return mealMap.values();
    }
}
