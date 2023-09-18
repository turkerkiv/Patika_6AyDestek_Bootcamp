package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operator extends User {
    public Operator(int id, String name, String username, String password, String userType) {
        super(id, name, username, password, userType);
    }

    public static List<User> getAllUsers() {
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

    public static boolean addUser(String name, String username, String password, String userType) {
        try {
            if (getUser(username) != null) {
                JOptionPane.showMessageDialog(null, "Username is taken.", "Error", JOptionPane.ERROR_MESSAGE);
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

    public static void deleteUser(int id) {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("delete from \"User\" where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean updateUser(int id, String name, String username, String password) {
        try {
            if (hasUserAlready(id, username)) {
                JOptionPane.showMessageDialog(null, "Username is taken.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            PreparedStatement st = DBConnector.getConn().prepareStatement("update \"User\" set name=?, username=?, password=? where id=?");
            st.setString(1, name);
            st.setString(2, username);
            st.setString(3, password);
            st.setInt(4, id);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static List<User> searchUsers(String nameToSearch) {
        List<User> usersList = new ArrayList<>();
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("SELECT * FROM \"User\" WHERE name LIKE ?");
            st.setString(1, "%" + nameToSearch + "%");
            ResultSet foundUsers = st.executeQuery();
            while (foundUsers.next()) {
                int id = foundUsers.getInt("id");
                String name = foundUsers.getString("name");
                String username = foundUsers.getString("username");
                String password = foundUsers.getString("password");
                String userType = foundUsers.getString("userType");

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

    public static User getUser(int id) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"User\" where id=?");
        st.setInt(1, id);
        ResultSet users = st.executeQuery();
        if (users.next()) {
            User us = new User(id, users.getString(2), users.getString(3), users.getString(4), users.getString(5));
            st.close();
            return us;
        } else {
            st.close();
            return null;
        }
    }

    public static User getUser(String username) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"User\" where username=?");
        st.setString(1, username);
        ResultSet users = st.executeQuery();
        if (users.next()) {
            User us = new User(users.getInt(1), users.getString(2), username, users.getString(4), users.getString(5));
            st.close();
            return us;
        } else {
            st.close();
            return null;
        }
    }

    public static Operator getOperator(String username) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"User\" where username=? AND \"userType\"=?");
        st.setString(1, username);
        st.setObject(2, "OPERATOR", Types.OTHER);
        ResultSet users = st.executeQuery();
        if (users.next()) {
            Operator us = new Operator(users.getInt(1), users.getString(2), username, users.getString(4), users.getString(5));
            st.close();
            return us;
        } else {
            st.close();
            return null;
        }
    }

    private static boolean hasUserAlready(int id, String username) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"User\" where username=?");
        st.setString(1, username);
        ResultSet users = st.executeQuery();
        boolean hasAlready = users.next() && users.getInt(1) != id;
        st.close();
        return hasAlready;
    }
}

