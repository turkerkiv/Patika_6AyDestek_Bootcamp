package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Config;
import Week6.PatikaClone.Helper.Helper;
import Week6.PatikaClone.Model.Course;
import Week6.PatikaClone.Model.User;
import Week6.PatikaClone.Model.Path;
import Week6.PatikaClone.Model.Content;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JTable tbl_courses;
    private JPanel pnl_add_content;
    private JTextField fld_content_name;
    private JTextArea area_desc;
    private JTextField fld_video_link;
    private JTable tbl_quiz_questions;
    private JLabel lbl_content_name;
    private JLabel lbl_content_desc;
    private JLabel lbl_video_link;
    private JLabel lbl_quiz_questions;
    private JScrollPane scrpnl_quiz_table;
    private JScrollPane scrpnl_courses;
    private JTable tbl_contents;
    private JScrollPane scrpnl_contents;
    private JPanel pnl_tables;
    private JButton btn_add_content;
    private User loggedEducator;

    public EducatorGUI(User loggedEducator) {
        this.loggedEducator = loggedEducator;

        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        updateEducatorRelatedCoursesTable();
        tbl_courses.getSelectionModel().addListSelectionListener(e -> {
            updateCourseRelatedContentsTable();
        });
        btn_add_content.addActionListener(e -> {
            addContent();
        });
    }

    private void updateEducatorRelatedCoursesTable() {
        try {
            List<Course> relatedCourses = Course.getAllCourses().stream().filter(c -> c.getUser_id() == loggedEducator.getId()).toList();
            DefaultTableModel mdl_relatedCourses = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            mdl_relatedCourses.setColumnIdentifiers(new Object[]{"ID", "COURSE", "PROG. LANG.", "PATH NAME"});
            for (Course c : relatedCourses) {
                Path p = c.getPath();
                String pname = p == null ? "" : p.getName();
                mdl_relatedCourses.addRow(new Object[]{c.getId(), c.getName(), c.getLanguage(), pname});
            }

            tbl_courses.setModel(mdl_relatedCourses);
            tbl_courses.getTableHeader().setReorderingAllowed(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCourseRelatedContentsTable() {
        int course_id = (int) tbl_courses.getValueAt(tbl_courses.getSelectedRow(),0);
        System.out.println(course_id + " sss");
        DefaultTableModel mdl_related_contents = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        mdl_related_contents.setColumnIdentifiers(new Object[]{"ID", "NAME", "DESCRIPTION", "VIDEO LINK"});

        try {
            for (Content c : Content.getFilteredContents(course_id)) {
                mdl_related_contents.addRow(new Object[]{c.getId(), c.getContentName(), c.getContentDesc(), c.getVideoLink()});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tbl_contents.setModel(mdl_related_contents);
        tbl_contents.getTableHeader().setReorderingAllowed(false);
    }

    private void addContent() {
        if (tbl_courses.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a course to add.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Helper.checkAnyEmpty(fld_content_name.getText(), fld_video_link.getText(), area_desc.getText())) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String contentName = fld_content_name.getText();
        String videoLink = fld_video_link.getText();
        String desc = area_desc.getText();
        int course_id = (int) tbl_courses.getValueAt(tbl_courses.getSelectedRow(), 0);

        try {
            Content.addContent(contentName,desc,videoLink,course_id);
            JOptionPane.showMessageDialog(null, "Added.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        fld_content_name.setText("");
        fld_video_link.setText("");
        area_desc.setText("");
        updateCourseRelatedContentsTable();
    }
}
