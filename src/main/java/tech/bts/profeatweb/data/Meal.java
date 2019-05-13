package tech.bts.profeatweb.data;

import java.util.HashMap;
import java.util.Map;

public class Meal {

    public enum DishType {
        STARTER('S'), MAIN('M');

        private char initialChar;

        DishType(char initialChar) {
            this.initialChar = initialChar;
        }
    }

    private String id;
    private String name;
    private double price;
    private int rate;
    private Restaurant restaurant;
    private DishType typeOfDish;
    private Map<Employee, String> feedbacks;
    private Map<String, Object> nutritionalInfo;
    //private String mainProtein;
    //private vegetables hasVegetables;


    public Meal() {
        this.feedbacks = new HashMap<>();
        this.nutritionalInfo = new HashMap<>();

    }

    public Meal(String name, double price, int rate, Restaurant restaurant, DishType typeOfDish) {
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.restaurant = restaurant;
        this.typeOfDish = typeOfDish;
        this.feedbacks = new HashMap<>();
        this.nutritionalInfo = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public DishType getTypeOfDish() {
        return typeOfDish;
    }

    public void setTypeOfDish(DishType typeOfDish) {
        this.typeOfDish = typeOfDish;
    }

    public Map<Employee, String> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Map<Employee, String> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Map<String, Object> getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(Map<String, Object> nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price + ", First or second: " + typeOfDish;
    }
}

