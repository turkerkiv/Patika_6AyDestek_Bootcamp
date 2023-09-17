package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Path {
    private int id;
    private String name;

    public Path(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static Path getPath(int id) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("select * from \"Path\" where id=?");
        st.setInt(1, id);
        ResultSet paths = st.executeQuery();
        if (paths.next()) {
            Path pt = new Path(id, paths.getString(2));
            st.close();
            return pt;
        } else {
            st.close();
            return null;
        }
    }

    public static List<Path> getAllPaths() {
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


    public static void addPath(String pathName) {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("insert into \"Path\" (name) values (?)");
            st.setString(1, pathName);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deletePath(int id) {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("delete from \"Path\" where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updatePath(int id, String newName) {
        try {
            PreparedStatement st = DBConnector.getConn().prepareStatement("UPDATE \"Path\" SET name=? where id=?");
            st.setString(1, newName);
            st.setInt(2, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
