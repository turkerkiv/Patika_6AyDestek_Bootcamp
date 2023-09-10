package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.*;
import Week6.PatikaClone.Model.*;

import javax.swing.*;

public class OperatorGUI extends JFrame{
    private JPanel wrapper;
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
    }
}
