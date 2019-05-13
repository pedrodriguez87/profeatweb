package tech.bts.profeatweb.data;

public class User {

    private String email;
    private String password;
    private String id;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
