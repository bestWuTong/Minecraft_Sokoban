package start;

import window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class StartButton extends JButton {
    public StartButton(MainWindow mainWindow){
        setText("开 始 游 戏");
        setPreferredSize(new Dimension(200,50));
        setFont(new Font("微软雅黑",Font.BOLD,20));
        setForeground(Color.white);
//        setBackground(new Color(50, 153, 94));
        setBackground(new Color(60,133, 39));
        setFocusPainted(false);     //去掉焦点框
        addActionListener(e -> {
            MainWindow.menu(mainWindow);
        });
    }
}
