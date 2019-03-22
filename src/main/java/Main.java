import data.Meal;
import data.Test;
import data.User;
import repository.MealRepository;

public class Main {

    public static void main(String[] args) {

        Meal paella = new Meal("Paella",9, "Fish", Meal.vegetables.YES, Meal.typeofdish.first);
        System.out.println(paella);
        MealRepository mealRepository = new MealRepository();

        mealRepository.create(paella);


    }

}
