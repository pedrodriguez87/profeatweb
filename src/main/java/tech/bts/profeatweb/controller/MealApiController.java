package tech.bts.profeatweb.controller;

import tech.bts.profeatweb.data.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bts.profeatweb.service.MealService;

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

    @RequestMapping(method = GET, path = "/{mealId}")
    public Meal getMealById(@PathVariable long id) throws Exception {
        Meal meal = mealService.getMealById(id);

        if (meal != null) {
            return meal;
        } else {
            throw new Exception();
        }
    }

    @RequestMapping(method = POST, path = "/{mealId")
    public long updateMeal(@PathVariable long id) {
        Meal meal = mealService.getMealById(id);
        mealService.updateMeal(meal);
        return meal.getId();
    }
}
