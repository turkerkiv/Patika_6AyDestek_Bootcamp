package Week6.PatikaClone.View;

import Week6.PatikaClone.Model.*;
import Week6.PatikaClone.Helper.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveQuestionGUI extends JFrame{
    private JTextPane txtpnl_question;
    private JButton checkAnswerButton;
    private JTextPane txtpnl_answer;
    private JTextArea area_yourAnswer;
    private JPanel wrapper;
    private Question q;
    public SolveQuestionGUI(Question q)
    {
        this.q = q;
        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        loadQuestion();
        checkAnswerButton.addActionListener(e -> {
            if(checkAnswer())
            {
                txtpnl_answer.setText("Correct!");
            }else
            {
                txtpnl_answer.setText("Wrong! The correct answer is: \n" + q.getAnswer());
            }
        });
    }

    private void loadQuestion()
    {
        txtpnl_question.setText(q.getQuestion());

        txtpnl_answer.setVisible(false);
        txtpnl_answer.setText(q.getAnswer());
    }

    private boolean checkAnswer()
    {
        String userAnswer = area_yourAnswer.getText();
        txtpnl_answer.setVisible(true);
        area_yourAnswer.setEnabled(false);
        area_yourAnswer.setEditable(false);
        return userAnswer.equals(q.getAnswer());
    }
}
