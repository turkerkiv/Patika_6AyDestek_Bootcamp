package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Content {
    private int id;
    private int course_id;
    private String contentName;
    private String contentDesc;
    private String videoLink;
    private Course relatedCourse;

    public Content(int id, int course_id, String contentName, String contentDesc, String videoLink) {
        this.id = id;
        this.course_id = course_id;
        this.contentName = contentName;
        this.contentDesc = contentDesc;
        this.videoLink = videoLink;

        try {
            relatedCourse = Course.getCourse(course_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getContentName() {
        return contentName;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public Course getRelatedCourse() {
        return relatedCourse;
    }

    public static List<Content> getFilteredContents(int course_id) throws SQLException
    {
        PreparedStatement pt = DBConnector.getConn().prepareStatement("select * from \"Content\" where course_id=?");
        pt.setInt(1, course_id);
        ResultSet rs = pt.executeQuery();
        List<Content> contents = new ArrayList<>();
        while(rs.next())
        {
            int id = rs.getInt(1);
            String name = rs.getString(3);
            String desc = rs.getString(4);
            String videoLink = rs.getString(5);
            contents.add(new Content(id, course_id,name,desc,videoLink));
        }
        pt.close();
        return contents;
    }

    public static void addContent(String name, String desc, String videoLink, int course_id) throws SQLException{
            PreparedStatement pt = DBConnector.getConn().prepareStatement("INSERT INTO \"Content\" (name,description,video_link,course_id) values (?,?,?,?)");
            pt.setString(1, name);
            pt.setString(2, desc);
            pt.setString(3, videoLink);
            pt.setInt(4, course_id);
            pt.executeUpdate();
            pt.close();
    }

    public static void deleteContent(int id) throws SQLException
    {
        Statement st = DBConnector.getConn().createStatement();
        st.executeUpdate("delete from \"Content\" where id="+id);
        st.close();
    }

    public static void updateContent(int id, String name, String desc, String videoLink) throws SQLException
    {
        PreparedStatement pt = DBConnector.getConn().prepareStatement("UPDATE \"Content\" SET name=?,description=?,video_link=? where id=?");
        pt.setString(1,name);
        pt.setString(2,desc);
        pt.setString(3,videoLink);
        pt.setInt(4,id);
        pt.executeUpdate();
        pt.close();
    }
}
