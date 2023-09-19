package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Config;
import Week6.PatikaClone.Helper.Helper;
import Week6.PatikaClone.Model.Question;

import javax.swing.*;
import java.sql.SQLException;

public class QuestionGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_question;
    private JTextField fld_answer;
    private JButton btn_add;
    private JLabel lbl_question;
    private JLabel lbl_answer;

    public QuestionGUI(int content_id) {
        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btn_add.addActionListener(e -> {
            String question = fld_question.getText();
            String answer = fld_answer.getText();
            try {
                Question.addQuestion(question, answer, content_id);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        });
    }
}
