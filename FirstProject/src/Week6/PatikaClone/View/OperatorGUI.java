package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.*;
import Week6.PatikaClone.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JButton btn_exit;
    private JPanel pnl_users;
    private JTable tbl_users;
    private JScrollPane scrpnl_users;
    private JLabel lbl_name;
    private JPanel pnl_user_add;
    private JTextField fld_name;
    private JTextField fld_username;
    private JComboBox cmb_userType;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JLabel lbl_userType;
    private JPasswordField fld_password;
    private JButton btn_add_user;
    private JButton btn_delete_user;
    private final Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;

        Helper.setTheme("Nimbus");
        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        lbl_welcome.setText("Welcome " + operator.getName());

        updateTable();

        //setting combobox
        cmb_userType.addItem("OPERATOR");
        cmb_userType.addItem("EDUCATOR");
        cmb_userType.addItem("STUDENT");
        cmb_userType.setSelectedIndex(0);

        //handle button click
        btn_add_user.addActionListener(e -> {
            addUser();
        });

        btn_delete_user.addActionListener(e -> {
            deleteUser();
        });

        //handle table cell value change
    }

    private void addUser() {
        String name = fld_name.getText();
        String username = fld_username.getText();
        String password = fld_password.getText();
        String userType = cmb_userType.getSelectedItem().toString();

        if (Helper.checkAnyEmpty(name, username, password)) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (operator.addUser(name, username, password, userType)) {
            JOptionPane.showMessageDialog(null, "Added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateTable();
        }

        clearInputs();
    }

    private void deleteUser() {
        int row = tbl_users.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row from table!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = (int) tbl_users.getValueAt(row, 0);
        operator.deleteUser(id);
        JOptionPane.showMessageDialog(null, "Deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        updateTable();
        clearInputs();
    }

    private void updateUser() {
        int row = tbl_users.getSelectedRow();
        int id = (int) tbl_users.getValueAt(row, 0);
        String name = (String) tbl_users.getValueAt(row, 1);
        String username = (String) tbl_users.getValueAt(row, 2);
        String password = (String) tbl_users.getValueAt(row, 3);
        if (!operator.updateUser(id, name, username, password)) {
            updateTable();
            return;
        }
        JOptionPane.showMessageDialog(null, "Updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateTable() {
        //Adding data to table
        DefaultTableModel mdl_users = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 4) return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column = {"ID", "Name", "Username", "Password", "User type"};
        mdl_users.setColumnIdentifiers(column);

        for (User u : operator.getUserList()) {
            Object[] row = {u.getId(), u.getName(), u.getUsername(), u.getPassword(), u.getUserType()};
            mdl_users.addRow(row);
        }
        tbl_users.getTableHeader().setReorderingAllowed(false);

        mdl_users.addTableModelListener(e -> {
            if (e.getType() != TableModelEvent.UPDATE) {
                return;
            }
            updateUser();
        });

        tbl_users.setModel(mdl_users);
    }

    private void clearInputs() {
        fld_name.setText("");
        fld_password.setText("");
        fld_username.setText("");
        cmb_userType.setSelectedIndex(0);
    }
}
