package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
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

        usersList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        });

        return usersList;
    }

    public void addUser(String name, String username, String password, String userType) {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("insert into \"User\" (name,username,password,\"userType\") values (?,?,?,?)");
            st.setString(1, name);
            st.setString(2, username);
            st.setString(3, password);
            st.setObject(4, userType, Types.OTHER);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteUser(int id)
    {
        try{
            PreparedStatement st = DBConnector.getConn().prepareStatement("delete from \"User\" where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
