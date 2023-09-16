package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.*;
import Week6.PatikaClone.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
    private JPanel pnl_search_user;
    private JLabel lbl_search_user;
    private JTextField fld_search_user;
    private JButton btn_search;
    private JPanel pnl_paths;
    private JScrollPane scrpnl_paths;
    private JTable tbl_paths;
    private JPanel pnl_add_path;
    private JLabel lbl_path_name;
    private JTextField fld_path_name;
    private JButton btn_add_path;
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

        updateUsersTable(operator.getAllUsers());

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
        btn_search.addActionListener(e -> {
            searchUsers();
        });

        //paths table ---
        updatePathsTable();
        btn_add_path.addActionListener(e -> {
            addPath();
        });
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
            updateUsersTable(operator.getAllUsers());
        }

        clearUserInputs();
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
        updateUsersTable(operator.getAllUsers());
        clearUserInputs();
    }

    private void updateUser() {
        int row = tbl_users.getSelectedRow();
        int id = (int) tbl_users.getValueAt(row, 0);
        String name = (String) tbl_users.getValueAt(row, 1);
        String username = (String) tbl_users.getValueAt(row, 2);
        String password = (String) tbl_users.getValueAt(row, 3);
        if (!operator.updateUser(id, name, username, password)) {
            updateUsersTable(operator.getAllUsers());
            return;
        }
        JOptionPane.showMessageDialog(null, "Updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchUsers() {
        if (btn_search.getText().isEmpty()) {
            updateUsersTable(operator.getAllUsers());
            return;
        }
        updateUsersTable(operator.searchUsers(fld_search_user.getText()));
        fld_search_user.setText("");
    }

    private void updateUsersTable(List<User> userList) {
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

        for (User u : userList) {
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

    private void clearUserInputs() {
        fld_name.setText("");
        fld_password.setText("");
        fld_username.setText("");
        cmb_userType.setSelectedIndex(0);
    }

    private void updatePathsTable() {
        DefaultTableModel mdl_paths = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] columns = {"ID", "NAME"};
        mdl_paths.setColumnIdentifiers(columns);

        for (Path p : operator.getAllPaths()) {
            Object[] row = {p.getId(), p.getName()};
            mdl_paths.addRow(row);
        }
        tbl_paths.getTableHeader().setReorderingAllowed(false);
        tbl_paths.setModel(mdl_paths);
        tbl_paths.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_paths.getColumnModel().getColumn(0).setMinWidth(100);

        //setting right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem update = new JMenuItem("Update");
        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener(e -> {
            deletePath();
        });
        popupMenu.add(update);
        popupMenu.add(delete);
        tbl_paths.setComponentPopupMenu(popupMenu);
        tbl_paths.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int clickedRow = tbl_paths.rowAtPoint(point);
                tbl_paths.setRowSelectionInterval(clickedRow, clickedRow);
            }
        });
    }

    private void addPath() {
        if (fld_path_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill the name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        operator.addPath(fld_path_name.getText());
        updatePathsTable();
        fld_path_name.setText("");
    }

    private void deletePath() {
        int row = tbl_paths.getSelectedRow();
        int id = (int) tbl_paths.getValueAt(row, 0);
        int selectedOpt = JOptionPane.showConfirmDialog(null, "Are you sure?", "WAIT", JOptionPane.YES_NO_OPTION);
        if (selectedOpt == JOptionPane.NO_OPTION) return;
        operator.deletePath(id);
        updatePathsTable();
    }
}
