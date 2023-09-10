package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.*;
import Week6.PatikaClone.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame{
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JButton btn_exit;
    private JPanel pnl_users;
    private JTable tbl_users;
    private JScrollPane scrpnl_users;
    private final Operator operator;

    public OperatorGUI(Operator operator){
        this.operator = operator;

        Helper.setTheme("Nimbus");
        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        lbl_welcome.setText("Welcome "+operator.getName());

        //Adding data to table
        DefaultTableModel mdl_users = new DefaultTableModel();
        Object[] column = {"ID", "Name", "Username", "Password", "User type"};
        mdl_users.setColumnIdentifiers(column);

        for(User u : operator.getUserList())
        {
            Object[] row = {u.getId(), u.getName(), u.getUsername(), u.getPassword(), u.getUserType()};
            mdl_users.addRow(row);
        }

        tbl_users.getTableHeader().setReorderingAllowed(false);
        tbl_users.setModel(mdl_users);
    }
}
