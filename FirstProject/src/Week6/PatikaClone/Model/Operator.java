package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Operator extends User {
    public Operator(int id, String name, String username, String password, String userType) {
        super(id, name, username, password, userType);
    }

    public List<User> getUserList() {
        List<User> usersList = new ArrayList<>();
        try {
            Statement st = DBConnector.getConn().createStatement();
            ResultSet usersSet = st.executeQuery("select * from \"User\"");
            while (usersSet.next()) {
                int id = usersSet.getInt("id");
                String name = usersSet.getString("name");
                String username = usersSet.getString("username");
                String password = usersSet.getString("password");
                String userType = usersSet.getString("userType");

                User user = new User(id, name, username, password, userType);
                usersList.add(user);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        usersList.sort((o1, o2) -> o1.getId() - o2.getId());

        return usersList;
    }

    public boolean addUser(String name, String username, String password, String userType) {
        try {
            if(hasUserAlready(username))
            {
                JOptionPane.showMessageDialog(null, "Username is taken." , "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            PreparedStatement st = DBConnector.getConn().prepareStatement("insert into \"User\" (name,username,password,\"userType\") values (?,?,?,?)");
            st.setString(1, name);
            st.setString(2, username);
            st.setString(3, password);
            st.setObject(4, userType, Types.OTHER);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void deleteUser(int id) {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("delete from \"User\" where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean hasUserAlready(String username) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"User\" where username=?");
        st.setString(1, username);
        ResultSet users = st.executeQuery();
        boolean hasAlready = users.next();
        st.close();
        return hasAlready;
    }
}
