package data;

public class Meal {

    private long id;
    private String name;
    private long price;
    private String mainprotein;
    private vegetables hasvegetables;
    private typeofdish typeofdish;

    public Meal(String name, long price, String mainprotein, vegetables hasvegetables, typeofdish typeofdish) {
        this.name = name;
        this.price = price;
        this.mainprotein = mainprotein;
        this.hasvegetables = hasvegetables;
        this.typeofdish = typeofdish;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getMainprotein() {
        return mainprotein;
    }

    public void setMainprotein(String mainprotein) {
        this.mainprotein = mainprotein;
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

