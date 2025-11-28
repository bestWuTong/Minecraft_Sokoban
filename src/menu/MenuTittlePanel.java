package menu;

import window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MenuTittlePanel extends JPanel {
    public MenuTittlePanel(MainWindow mainWindow){
        JLabel label = new JLabel();
        label.setText("选 择 关 卡");
        label.setFont(new Font("微软雅黑",Font.BOLD,40));
        label.setForeground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(
                mainWindow.getHeight()/10, 0, 0, 0));
        add(label);
    }

}
