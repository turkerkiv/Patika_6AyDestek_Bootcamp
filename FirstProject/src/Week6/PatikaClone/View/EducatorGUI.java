package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Config;
import Week6.PatikaClone.Helper.Helper;

import javax.swing.*;

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

    public EducatorGUI()
    {
        setContentPane(wrapper);
        setSize(680, 480);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
