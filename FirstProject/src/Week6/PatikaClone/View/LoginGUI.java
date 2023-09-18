package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.*;
import Week6.PatikaClone.Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_headline;
    private JLabel lbl_loginScr;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JLabel lbl_username;
    private JButton btn_login;
    private JLabel lbl_password;
    private JPanel wrp_header;
    private JPanel wrp_inputs;
    private JButton btn_signup;

    public LoginGUI() {

        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btn_login.addActionListener(e -> {
            login();
        });

        btn_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignupGUI signup = new SignupGUI();
                dispose();
            }
        });
    }

    private void login() {
        if (Helper.checkAnyEmpty(fld_password.getText(), fld_username.getText())) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Operator op = Operator.getOperator(fld_username.getText());
            if (op == null) {
                JOptionPane.showMessageDialog(null, "There is no user with that username", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!op.getPassword().equals(fld_password.getText())) {
                JOptionPane.showMessageDialog(null, "Password is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            dispose();
            OperatorGUI opGUI = new OperatorGUI(op);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
