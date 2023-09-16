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

    public List<User> getAllUsers() {
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
            if (hasUserAlready(username)) {
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

    public boolean updateUser(int id, String name, String username, String password) {
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

    public List<User> searchUsers(String nameToSearch) {
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

    public List<Path> getAllPaths() {
        List<Path> pathsList = new ArrayList<>();
        try {
            Statement st = DBConnector.getConn().createStatement();
            ResultSet pathsSet = st.executeQuery("select * from \"Path\"");
            while (pathsSet.next()) {
                int id = pathsSet.getInt("id");
                String name = pathsSet.getString("name");
                Path path = new Path(id, name);
                pathsList.add(path);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        pathsList.sort((o1, o2) -> o1.getId() - o2.getId());
        return pathsList;
    }

    private boolean hasUserAlready(String username) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"User\" where username=?");
        st.setString(1, username);
        ResultSet users = st.executeQuery();
        boolean hasAlready = users.next();
        st.close();
        return hasAlready;
    }

    private boolean hasUserAlready(int id, String username) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"User\" where username=?");
        st.setString(1, username);
        ResultSet users = st.executeQuery();
        boolean hasAlready = users.next() && users.getInt(1) != id;
        st.close();
        return hasAlready;
    }

    public void addPath(String pathName)
    {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("insert into \"Path\" (name) values (?)");
            st.setString(1, pathName);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletePath(int id)
    {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("delete from \"Path\" where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatePath(int id, String newName)
    {
        try{
            PreparedStatement st = DBConnector.getConn().prepareStatement("UPDATE \"Path\" SET name=? where id=?");
            st.setString(1, newName);
            st.setInt(2, id);
            st.executeUpdate();
            st.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
