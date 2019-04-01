package tech.bts.profeatweb.service;

import tech.bts.profeatweb.data.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bts.profeatweb.repository.MealRepositoryJdbc;

import java.util.Collection;

@Service
public class MealService {

    private MealRepositoryJdbc mealRepo;

    @Autowired
    public MealService(MealRepositoryJdbc mealRepo) {
        this.mealRepo = mealRepo;
    }

    public Meal createMeal() {
        Meal meal = new Meal();
        mealRepo.create(meal);
        return meal;
    }
    public Collection<Meal> getAllMeals() {
        return mealRepo.getAll();
    }

    public Meal getMealById(long id) {
        return mealRepo.getById(id);
    }


}
