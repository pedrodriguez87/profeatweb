package controller;

import data.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MealService;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "/api/meals")
public class MealApiController {

    private MealService mealService;

    @Autowired
    public MealApiController(MealService mealService) {
        this.mealService = mealService;
    }

    @RequestMapping(method = POST)
    public long createMeal() {

        Meal meal = mealService.createMeal();
        return meal.getId();
    }

    @RequestMapping(method = GET)
    public Collection<Meal> getAllMeals() {

        return mealService.getAllMeals();
    }
}
