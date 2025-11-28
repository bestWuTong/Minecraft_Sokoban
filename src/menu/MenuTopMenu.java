package menu;

import window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MenuTopMenu extends JMenuBar {
    public MenuTopMenu(MainWindow mainWindow){
        setLayout(new FlowLayout((FlowLayout.LEFT)));
//        setBackground(new Color(42, 135, 81));
        setBackground(new Color(49, 50, 51));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));//边框

        JMenuItem backToStart = new JMenuItem("返回主菜单");
        backToStart.setFont(new Font("等线",Font.BOLD,15));
        backToStart.setBackground(new Color(199, 204, 204));

        backToStart.addActionListener(e -> {
            MainWindow.start(mainWindow);
        });

        add(backToStart);
    }
}
