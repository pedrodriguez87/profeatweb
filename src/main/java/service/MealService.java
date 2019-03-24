package service;

import data.Meal;
import repository.MealRepository;

import java.util.Collection;

public class MealService {

    private MealRepository mealRepo;

    public MealService(MealRepository mealRepo) {
        this.mealRepo = mealRepo;
    }

    public Meal createMeal() {
        return null;
    }
    public Collection<Meal> getAllMeals() {

        return mealRepo.getAll();
    }


}
