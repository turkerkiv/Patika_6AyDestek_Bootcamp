package Week6.PatikaClone.Model;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String userType;

    public User(String name, String username, String password, String userType){
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}
