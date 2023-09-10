package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String userType;

    public User(int id, String name, String username, String password, String userType) {
        this.id = id;
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

    public List<User> getUserList() {
        List<User> usersList = new ArrayList<>();
        try {
            Statement st = DBConnector.getConn().createStatement();
            ResultSet usersSet = st.executeQuery("select * from 'User'");
            while (usersSet.next()) {
                int id = usersSet.getInt("id");
                String name = usersSet.getString("name");
                String username = usersSet.getString("username");
                String password = usersSet.getString("password");
                String userType = usersSet.getString("userType");

                User user = new User(id, name, username, password, userType);
                usersList.add(user);
            }

            return usersList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
