package data;

public class User {

    private String name;
    private String surname;
    private String username;
    private String password;
    private int age;
    private double height;
    private double weight;
    private Company company;
    private Test test;

    public User(String name, String surname, String username, String password, int age, double height, double weight, Company company, Test test) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.company = company;
        this.test = test;
    }
}
