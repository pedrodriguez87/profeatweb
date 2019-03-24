package data;

import java.sql.Time;
import java.util.Date;
import java.util.Map;

public class Company {

    private long id;
    private String name;
    private String password;
    private String email;
    private String description;
    private String delivery;
    private Time time;

    public Company(long id, String name, String password, String email, String description, String delivery, Time time) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.description = description;
        this.delivery = delivery;
        this.time = time;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
