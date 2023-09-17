package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private int user_id;
    private int path_id;
    private String name;
    private String language;

    private User user;
    private Path path;

    public Course(int id, int user_id, int path_id, String name, String language) {
        this.id = id;
        this.user_id = user_id;
        this.path_id = path_id;
        this.name = name;
        this.language = language;
        try {
            user = Operator.getUser(user_id);
            path = Path.getPath(path_id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPath_id() {
        return path_id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public User getUser() {
        return user;
    }

    public Path getPath() {
        return path;
    }

    public static List<Course> getAllCourses() throws SQLException {
        Statement st = DBConnector.getConn().createStatement();
        ResultSet courses = st.executeQuery("select * from \"Course\"");
        List<Course> coursesList = new ArrayList<>();
        while (courses.next()) {
            int id = courses.getInt(1);
            int user_id = courses.getInt(2);
            int path_id = courses.getInt(3);
            String name = courses.getString(4);
            String lang = courses.getString(5);
            coursesList.add(new Course(id, user_id, path_id, name, lang));
        }
        st.close();
        return coursesList;
    }

    public static void addCourse(int user_id, int path_id, String name, String language) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("insert into \"Course\" (user_id, path_id, name, language) values (?,?,?,?)");
        st.setInt(1, user_id);
        st.setInt(2, path_id);
        st.setString(3, name);
        st.setString(4, language);
        st.executeUpdate();
        st.close();
    }

    public static void deleteCourse(int id) throws SQLException
    {
        PreparedStatement st = DBConnector.getConn().prepareStatement("delete from \"Course\" where id=?");
        st.setInt(1, id);
        st.executeUpdate();
        st.close();
    }

    public static void updateCourse(int id, int user_id, int path_id, String name, String language) throws SQLException {
        PreparedStatement st = DBConnector.getConn().prepareStatement("update \"Course\" set user_id=?, path_id=?, name=?, language=? where id=?");
        st.setInt(1, user_id);
        st.setInt(2, path_id);
        st.setString(3, name);
        st.setString(4, language);
        st.setInt(5, id);
        st.executeUpdate();
        st.close();
    }
}
