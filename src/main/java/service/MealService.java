package service;

import data.Meal;
import repository.MealRepository;

public class MealService {

    private MealRepository mealRepo;

    public MealService(MealRepository mealRepo) {
        this.mealRepo = mealRepo;
    }

    public Meal createMeal() {
        return null;
    }

}
