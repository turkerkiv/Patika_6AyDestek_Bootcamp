package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Config;
import Week6.PatikaClone.Helper.Helper;
import Week6.PatikaClone.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_folders;
    private JButton btn_home_folder;
    private JTable tbl_folders;
    private JTextArea area_headline;
    private JTextArea area_description;
    private JTextArea area_videoLink;
    private JPanel pnl_content;
    private User loggedStudent;

    public StudentGUI(User loggedStudent) {
        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        loadPaths();
        btn_home_folder.addActionListener(e -> {
          loadHomeFolder();
        });
    }

    private void loadPaths() {
        DefaultTableModel mdl_paths = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] columns = {"ID", "NAME"};
        mdl_paths.setColumnIdentifiers(columns);

        for (Path p : Path.getAllPaths()) {
            Object[] row = {p.getId(), p.getName()};
            mdl_paths.addRow(row);
        }
        tbl_folders.getTableHeader().setReorderingAllowed(false);

        tbl_folders.setModel(mdl_paths);
        //set right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem enter = new JMenuItem("Enter");
        enter.addActionListener(e -> {
            loadPathRelatedCourses((int) tbl_folders.getValueAt(tbl_folders.getSelectedRow(), 0));
        });

        popupMenu.add(enter);
        tbl_folders.setComponentPopupMenu(popupMenu);
        tbl_folders.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int clickedRow = tbl_folders.rowAtPoint(point);
                tbl_folders.setRowSelectionInterval(clickedRow, clickedRow);
            }
        });

    }

    private void loadPathRelatedCourses(int pathID) {
        DefaultTableModel mdl_courses = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mdl_courses.setColumnIdentifiers(new Object[]{"ID", "USER", "NAME", "LANGUAGE"});
        try {
            for (Course c : Course.getCoursesByPathID(pathID)) {
                User user = c.getUser();
                String userName = user == null ? "" : user.getName();
                Object[] row = {c.getId(), userName, c.getName(), c.getLanguage()};
                mdl_courses.addRow(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tbl_folders.getTableHeader().setReorderingAllowed(false);
        tbl_folders.setModel(mdl_courses);

        //set right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem enter = new JMenuItem("Enter");
        enter.addActionListener(e -> {
            loadCourseRelatedContents((int) tbl_folders.getValueAt(tbl_folders.getSelectedRow(), 0));
        });

        popupMenu.add(enter);
        tbl_folders.setComponentPopupMenu(popupMenu);
        tbl_folders.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int clickedRow = tbl_folders.rowAtPoint(point);
                tbl_folders.setRowSelectionInterval(clickedRow, clickedRow);
            }
        });
    }

    private void loadCourseRelatedContents(int courseID) {
        DefaultTableModel mdl_related_contents = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        mdl_related_contents.setColumnIdentifiers(new Object[]{"ID", "NAME", "DESCRIPTION", "VIDEO LINK"});
        try {
            for (Content c : Content.getFilteredContents(courseID)) {
                mdl_related_contents.addRow(new Object[]{c.getId(), c.getContentName(), c.getContentDesc(), c.getVideoLink()});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tbl_folders.setModel(mdl_related_contents);
        tbl_folders.getTableHeader().setReorderingAllowed(false);

        //set right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem enter = new JMenuItem("Enter");
        enter.addActionListener(e -> {
            loadContentPage((int) tbl_folders.getValueAt(tbl_folders.getSelectedRow(), 0));
        });

        popupMenu.add(enter);
        tbl_folders.setComponentPopupMenu(popupMenu);
        tbl_folders.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int clickedRow = tbl_folders.rowAtPoint(point);
                tbl_folders.setRowSelectionInterval(clickedRow, clickedRow);
            }
        });
    }

    private void loadContentPage(int id) {
        try {
            Content c = Content.getContent(id);
            area_headline.setText(c.getContentName());
            area_description.setText(c.getContentDesc());
            area_videoLink.setText(c.getVideoLink());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadHomeFolder()
    {
        area_description.setText("");
        area_headline.setText("");
        area_videoLink.setText("");
        loadPaths();
    }
}
