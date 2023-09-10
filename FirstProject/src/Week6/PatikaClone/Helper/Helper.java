package Week6.PatikaClone.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static Point getCenterOfScreen(Dimension sizeOfFrame)
    {
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width / 2 ) - (sizeOfFrame.width / 2);
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (sizeOfFrame.height / 2);
        return new Point(x, y);
    }

    public static void setTheme(String themeName)
    {
        for(UIManager.LookAndFeelInfo theme : UIManager.getInstalledLookAndFeels())
        {
            if(themeName.equals(theme.getName()))
            {
                try {
                    UIManager.setLookAndFeel(theme.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
