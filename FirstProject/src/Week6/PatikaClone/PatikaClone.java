package Week6.PatikaClone;

import javax.swing.*;

public class PatikaClone extends JFrame{
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

    public PatikaClone(){
        setContentPane(wrapper);
        setSize(680, 480);
        setTitle("Patika");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
