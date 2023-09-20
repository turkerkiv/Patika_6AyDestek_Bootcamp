package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Config;
import Week6.PatikaClone.Helper.Helper;
import Week6.PatikaClone.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_folders;
    private JButton btn_home_folder;
    private JTable tbl_folders;
    private JTextArea area_headline;
    private JTextArea area_description;
    private JTextArea area_videoLink;
    private JPanel pnl_content;
    private JButton btn_rate;
    private JTable tbl_questions;
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
            if(tbl_folders.getSelectedRow() == -1) return;
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
            if(tbl_folders.getSelectedRow() == -1) return;
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
        DefaultTableModel mdl_questions = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mdl_questions.setColumnIdentifiers(new Object[]{"ID","NAME","DESCRIPTION","VIDEO LINK"});
        try {
            for (Content c : Content.getFilteredContents(courseID))
            {
                mdl_questions.addRow(new Object[]{c.getId(), c.getContentName(), c.getContentDesc(), c.getVideoLink()});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tbl_folders.setModel(mdl_questions);
        tbl_folders.getTableHeader().setReorderingAllowed(false);

        //set right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem enter = new JMenuItem("Enter");
        enter.addActionListener(e -> {
            if(tbl_folders.getSelectedRow() == -1) return;
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
            loadQuestions(c.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadQuestions(int contentID) {
        DefaultTableModel mdl_questions = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Question> quests = new ArrayList<>();
        mdl_questions.setColumnIdentifiers(new Object[]{"ID", "QUESTION"});
        try {
            for (Question c : Question.getFilteredQuestions(contentID)) {
                mdl_questions.addRow(new Object[]{c.getId(), c.getQuestion()});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tbl_questions.setModel(mdl_questions);
        tbl_questions.getTableHeader().setReorderingAllowed(false);

        //set right click menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem solve = new JMenuItem("Solve");
        solve.addActionListener(e -> {
            if(tbl_questions.getSelectedRow() == -1) return;
            int id = (int) tbl_questions.getValueAt(tbl_questions.getSelectedRow(), 0);
            Question q = quests.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        });

        popupMenu.add(solve);
        tbl_questions.setComponentPopupMenu(popupMenu);
        tbl_questions.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int clickedRow = tbl_questions.rowAtPoint(point);
                tbl_questions.setRowSelectionInterval(clickedRow, clickedRow);
            }
        });
    }

    private void loadHomeFolder() {
        area_description.setText("");
        area_headline.setText("");
        area_videoLink.setText("");
        loadPaths();
        tbl_questions.setModel(new DefaultTableModel());
    }
}
