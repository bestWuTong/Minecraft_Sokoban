package menu;

import playing.GameMap;
import window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MenuButtonPanel extends JPanel {
    public MenuButtonPanel(MainWindow mainWindow){
        setLayout(new FlowLayout(FlowLayout.CENTER,25,20));
        setBorder(BorderFactory.createEmptyBorder(
                mainWindow.getHeight()/20,
                mainWindow.getWidth()/5,
                0,
                mainWindow.getWidth()/5));

        int levelNumber = GameMap.getLevelNumber();   //关卡数量

        JButton[] buttons = new JButton[levelNumber];

        for (int i = 0; i < levelNumber; i++) {
            buttons[i] = new JButton("第 " + (i + 1) + " 关");
            buttons[i].setPreferredSize(new Dimension(100,50));
            buttons[i].setFont(new Font("微软雅黑",Font.BOLD,15));
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));//边框
//            buttons[i].setBackground(new Color(88, 88, 90));//未解锁颜色
            buttons[i].setBackground(new Color(201, 201, 211));//未通关颜色
//            buttons[i].setBackground(new Color(70, 151, 44));//通关颜色
            buttons[i].setFocusPainted(false);     //去掉焦点框
            int level = i + 1;
            buttons[i].addActionListener(e -> {
                MainWindow.playing(mainWindow, level);
            });

            add(buttons[i]);
        }
    }
}
