package Week6.PatikaClone.Helper;

import java.awt.*;

public class Helper {
    public static Point getCenterOfScreen(Dimension sizeOfFrame)
    {
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width / 2 ) - (sizeOfFrame.width / 2);
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (sizeOfFrame.height / 2);
        return new Point(x, y);
    }
}
