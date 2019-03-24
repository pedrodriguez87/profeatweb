package tech.bts.profeatweb.data;

import java.util.Map;

public class Meal {

    private long id;
    private String name;
    private double price;
    private int rate;
    private String mainprotein;
    private Restaurant restaurant;
    private vegetables hasvegetables;
    private typeofdish typeofdish;
    private Map<Employee, String> feedbacks;

    public Meal() {

    }

    public Meal(long id, String name, double price, int rate, String mainprotein, Restaurant restaurant, vegetables hasvegetables, Meal.typeofdish typeofdish, Map<Employee, String> feedbacks) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.mainprotein = mainprotein;
        this.restaurant = restaurant;
        this.hasvegetables = hasvegetables;
        this.typeofdish = typeofdish;
        this.feedbacks = feedbacks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getMainprotein() {
        return mainprotein;
    }

    public void setMainprotein(String mainprotein) {
        this.mainprotein = mainprotein;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public vegetables getHasvegetables() {
        return hasvegetables;
    }

    public void setHasvegetables(vegetables hasvegetables) {
        this.hasvegetables = hasvegetables;
    }

    public Meal.typeofdish getTypeofdish() {
        return typeofdish;
    }

    public void setTypeofdish(Meal.typeofdish typeofdish) {
        this.typeofdish = typeofdish;
    }

    public enum vegetables {
        YES, NO
    }

    public enum typeofdish {
        first, second
    }

    @Override
    public String toString() {
        return "Name: " + name + " ,Price: " + price + " ,Protein: " + mainprotein +
                " ,Vegetables: " + hasvegetables + " ,First or second: " + typeofdish;
    }
}

