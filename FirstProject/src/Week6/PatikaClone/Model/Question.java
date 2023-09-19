package Week6.PatikaClone.Model;

import Week6.PatikaClone.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String question;
    private String answer;
    private int content_id;
    private Content relatedContent;

    public Question(int id, String question, String answer, int content_id) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.content_id = content_id;
        try {
            relatedContent = Content.getContent(content_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getContent_id() {
        return content_id;
    }

    public Content getRelatedContent() {
        return relatedContent;
    }

    public static List<Question> getFilteredQuestions(int content_id) throws SQLException {
        List<Question> questions = new ArrayList<>();
        Statement st = DBConnector.getConn().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM \"Question\" Where content_id=" + content_id);
        while (rs.next()) {
            int id = rs.getInt(1);
            String ques = rs.getString(2);
            String ans = rs.getString(3);
            questions.add(new Question(id, ques, ans, content_id));
        }
        rs.close();
        return questions;
    }

    public static void addQuestion(int id, String ques, String ans, int content_id) throws SQLException {
        PreparedStatement pt = DBConnector.getConn().prepareStatement("INSERT INTO \"Question\" (question, answer, course_id) values(?,?,?)");
        pt.setString(1, ques);
        pt.setString(2, ans);
        pt.setInt(3, content_id);
        pt.executeUpdate();
        pt.close();
    }
}
