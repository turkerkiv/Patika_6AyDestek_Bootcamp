package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Config;
import Week6.PatikaClone.Helper.Helper;
import Week6.PatikaClone.Model.Operator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_name;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_signup;
    private JLabel lbl_name;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JPanel pnl_signup;

    public SignupGUI(){
        setContentPane(wrapper);
        setSize(250, 250);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btn_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.checkAnyEmpty(fld_name.getText(), fld_username.getText(), fld_password.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                signup();
                LoginGUI login = new LoginGUI();
                dispose();
            }
        });
    }

    private void signup()
    {
        String name = fld_name.getText();
        String username = fld_username.getText();
        String password = fld_password.getText();
        Operator.addUser(name,username,password,"STUDENT");
    }
}
