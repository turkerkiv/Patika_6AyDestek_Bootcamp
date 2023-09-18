package Week6.PatikaClone.View;

import Week6.PatikaClone.Helper.Config;
import Week6.PatikaClone.Helper.Helper;
import Week6.PatikaClone.Helper.UpdateCallback;
import Week6.PatikaClone.Model.Path;

import javax.swing.*;

public class UpdatePathGUI extends JFrame {

    private JPanel wrapper;
    private JLabel lbl_path_name;
    private JButton btn_update_path;
    private JTextField fld_path_name;

    public UpdatePathGUI(Path path, UpdateCallback callback)
    {
        setContentPane(wrapper);
        setSize(250, 250);
        setLocation(Helper.getCenterOfScreen(getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        fld_path_name.setText(path.getName());
        btn_update_path.addActionListener(e -> {
            if(fld_path_name.getText().isEmpty() || fld_path_name.getText().equals(path.getName())) {
                JOptionPane.showMessageDialog(null, "Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            callback.apply(path.getId(), fld_path_name.getText());
            dispose();
        });
    }
}
