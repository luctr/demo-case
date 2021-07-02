package model;

public class User {
    private int id;
    private String name;
    private int password;
    private String role;

    public User(int id, String name, int password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
