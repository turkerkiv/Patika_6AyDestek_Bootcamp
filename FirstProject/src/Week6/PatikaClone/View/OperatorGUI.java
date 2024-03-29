package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.*;
import Week6.PatikaClone.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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
    private JPanel pnl_courses;
    private JTable tbl_courses;
    private JScrollPane scrpnl_courses;
    private JPanel pnl_add_course;
    private JTextField fld_course_name;
    private JTextField fld_prog_lang;
    private JComboBox cmb_path_select;
    private JComboBox cmb_teacher_select;
    private JButton btn_add_course;
    private JLabel lbl_course_name;
    private JLabel lbl_prog_lang;
    private JLabel lbl_path_select;
    private JLabel lbl_teacher_select;
    private JButton btn_update_course;
    private final Operator loggedInOperator;

    public OperatorGUI(Operator operator) {
        this.loggedInOperator = operator;

        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        lbl_welcome.setText("Welcome " + operator.getName());

        updateUsersTable(Operator.getAllUsers());

        //setting combobox
        cmb_userType.addItem("EDUCATOR");
        cmb_userType.addItem("STUDENT");
        cmb_userType.setSelectedIndex(0);

        //handle button click
        btn_add_user.addActionListener(e -> {
            addUser();
            updateCoursesTable();
        });

        btn_delete_user.addActionListener(e -> {
            deleteUser();
            updateCoursesTable();
        });

        //handle table cell value change
        btn_search.addActionListener(e -> {
            searchUsers();
        });

        //paths TAB ---
        updatePathsTable();
        btn_add_path.addActionListener(e -> {
            addPath();
            updateCoursesTable();
        });

        //courses TAB ---
        updateCoursesTable();
        btn_add_course.addActionListener(e -> {
            addCourse();
        });
        btn_update_course.addActionListener(e -> {
            updateCourse();
            btn_add_course.setEnabled(true);
            btn_update_course.setEnabled(false);
        });
        btn_exit.addActionListener(e -> {
            dispose();
            LoginGUI newLoginGUI = new LoginGUI();
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

        if (Operator.addUser(name, username, password, userType)) {
            JOptionPane.showMessageDialog(null, "Added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateUsersTable(Operator.getAllUsers());
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
        String userType = (String) tbl_users.getValueAt(row, 4);
        if(userType.equals("OPERATOR")) {
            JOptionPane.showMessageDialog(null, "Cannot delete a operator!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Operator.deleteUser(id);
        JOptionPane.showMessageDialog(null, "Deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        updateUsersTable(Operator.getAllUsers());
        clearUserInputs();
    }

    private void updateUser() {
        int row = tbl_users.getSelectedRow();
        int id = (int) tbl_users.getValueAt(row, 0);
        String name = (String) tbl_users.getValueAt(row, 1);
        String username = (String) tbl_users.getValueAt(row, 2);
        String password = (String) tbl_users.getValueAt(row, 3);
        if (!Operator.updateUser(id, name, username, password)) {
            updateUsersTable(Operator.getAllUsers());
            return;
        }
        JOptionPane.showMessageDialog(null, "Updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchUsers() {
        if (btn_search.getText().isEmpty()) {
            updateUsersTable(Operator.getAllUsers());
            return;
        }
        updateUsersTable(Operator.searchUsers(fld_search_user.getText()));
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
            updateCoursesTable();
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

        for (Path p : Path.getAllPaths()) {
            Object[] row = {p.getId(), p.getName()};
            mdl_paths.addRow(row);
        }
        tbl_paths.getTableHeader().setReorderingAllowed(false);

        mdl_paths.addTableModelListener(e -> {
            if (e.getType() != TableModelEvent.UPDATE) return;
            updatePathsTable();
        });

        tbl_paths.setModel(mdl_paths);
        tbl_paths.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_paths.getColumnModel().getColumn(0).setMinWidth(100);

        //setting right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem update = new JMenuItem("Update");
        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener(e -> {
            deletePath();
            updateCoursesTable();
        });

        update.addActionListener(e -> {
            openPathUpdatePopup();
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

        Path.addPath(fld_path_name.getText());
        updatePathsTable();
        fld_path_name.setText("");
    }

    private void deletePath() {
        int row = tbl_paths.getSelectedRow();
        int id = (int) tbl_paths.getValueAt(row, 0);
        int selectedOpt = JOptionPane.showConfirmDialog(null, "Are you sure?", "WAIT", JOptionPane.YES_NO_OPTION);
        if (selectedOpt == JOptionPane.NO_OPTION) return;
        Path.deletePath(id);
        updatePathsTable();
    }

    private void openPathUpdatePopup() {
        int row = tbl_paths.getSelectedRow();
        int id = (int) tbl_paths.getValueAt(row, 0);
        String name = (String) tbl_paths.getValueAt(row, 1);
        UpdatePathGUI updatePopup = new UpdatePathGUI(new Path(id, name), (idToUpdate, newName) -> {
            Path.updatePath(idToUpdate, newName);
            updatePathsTable();
            updateCoursesTable();
        });
    }

    private void updateCoursesTable() {
        DefaultTableModel mdl_courses = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mdl_courses.setColumnIdentifiers(new Object[]{"ID", "USER", "PATH", "NAME", "LANGUAGE"});
        try {
            for (Course c : Course.getAllCourses()) {
                User user = c.getUser();
                Path pt = c.getPath();
                String userName = user == null ? "" : user.getName();
                String pathName = pt == null ? "" : pt.getName();
                Object[] row = {c.getId(), userName, pathName, c.getName(), c.getLanguage()};
                mdl_courses.addRow(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tbl_courses.getTableHeader().setReorderingAllowed(false);
        tbl_courses.setModel(mdl_courses);

        //set right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem update = new JMenuItem("Update");
        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener(e -> {
            deleteCourse();
        });

        update.addActionListener(e -> {
            setUpUpdatingCourse();
        });
        popupMenu.add(update);
        popupMenu.add(delete);
        tbl_courses.setComponentPopupMenu(popupMenu);
        tbl_courses.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int clickedRow = tbl_courses.rowAtPoint(point);
                tbl_courses.setRowSelectionInterval(clickedRow, clickedRow);
            }
        });

        //fill comboboxes
        cmb_teacher_select.removeAllItems();
        cmb_path_select.removeAllItems();
        Operator.getAllUsers().forEach(u -> {
            if (!u.getUserType().equals("EDUCATOR")) return;
            cmb_teacher_select.addItem(u);
        });
        Path.getAllPaths().forEach(p -> {
            cmb_path_select.addItem(p);
        });
    }

    private void addCourse() {
        if (fld_course_name.getText().isEmpty() || fld_prog_lang.getText().isEmpty()) return;
        String name = fld_course_name.getText();
        String lang = fld_prog_lang.getText();
        int userID = ((User) cmb_teacher_select.getSelectedItem()).getId();
        int pathID = ((Path) cmb_path_select.getSelectedItem()).getId();
        try {
            Course.addCourse(userID, pathID, name, lang);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        updateCoursesTable();
    }

    private void deleteCourse() {
        int row = tbl_courses.getSelectedRow();
        int id = (int) tbl_courses.getValueAt(row, 0);
        int selectedOpt = JOptionPane.showConfirmDialog(null, "Are you sure?", "WAIT", JOptionPane.YES_NO_OPTION);
        if (selectedOpt == JOptionPane.NO_OPTION) return;
        try {
            Course.deleteCourse(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        updateCoursesTable();
    }

    private void setUpUpdatingCourse() {
        int row = tbl_courses.getSelectedRow();
        int id = (int) tbl_courses.getValueAt(row, 0);
        Course course = null;
        try {
            course = Course.getCourse(id);
        } catch (SQLException e) {
            System.out.println(e);
        }
        fld_course_name.setText(course.getName());
        fld_prog_lang.setText(course.getLanguage());

        setTeacherCmb(course.getUser_id());
        setPathCmb(course.getPath_id());

        btn_add_course.setEnabled(false);
        btn_update_course.setEnabled(true);
        btn_add_course.setText(String.valueOf(id));
    }

    private void updateCourse() {
        if (Helper.checkAnyEmpty(fld_course_name.getText(), fld_prog_lang.getText())) return;

        int id = Integer.parseInt(btn_add_course.getText());
        btn_add_course.setText("Add course");
        int userID = ((User) cmb_teacher_select.getSelectedItem()).getId();
        int pathID = ((Path) cmb_path_select.getSelectedItem()).getId();
        String name = (String) fld_course_name.getText();
        String lang = (String) fld_prog_lang.getText();
        try {
            Course.updateCourse(id, userID, pathID, name, lang);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        updateCoursesTable();
    }

    private void setTeacherCmb(int id) {
        for (int i = 0; i < cmb_teacher_select.getItemCount(); i++)
        {
            User us = (User) cmb_teacher_select.getItemAt(i);
            if(us != null && id == us.getId())
            {
                cmb_teacher_select.setSelectedIndex(i);
                return;
            }
        }
    }

    private void setPathCmb(int id) {
        for (int i = 0; i < cmb_path_select.getItemCount(); i++)
        {
            Path us = (Path) cmb_path_select.getItemAt(i);
            if(us != null && id == us.getId())
            {
                cmb_path_select.setSelectedIndex(i);
                return;
            }
        }
    }
}
