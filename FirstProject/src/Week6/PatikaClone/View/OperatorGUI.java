package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Helper;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class OperatorGUI extends JFrame{
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

    public OperatorGUI(){
        for(UIManager.LookAndFeelInfo theme : UIManager.getInstalledLookAndFeels())
        {
            if("Nimbus".equals(theme.getName()))
            {
                try {
                    UIManager.setLookAndFeel(theme.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle("Patika");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btn_login.addActionListener(e -> {
            if(fld_username.getText().length() == 0 || fld_password.getText().length() == 0)
            {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
