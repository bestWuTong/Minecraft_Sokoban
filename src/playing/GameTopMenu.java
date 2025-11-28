package playing;

import window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class GameTopMenu extends JMenuBar {
    //返回关卡菜单、重置游戏地图
    public GameTopMenu(MainWindow mainWindow, int level){
        setLayout(new FlowLayout((FlowLayout.LEFT)));
//        setBackground(new Color(42, 135, 81));
        setBackground(new Color(49, 50, 51));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));//边框

        JMenuItem backToMenu = new JMenuItem("返回关卡目录");
        JMenuItem resetMap = new JMenuItem("重置");
        backToMenu.setFont(new Font("等线",Font.BOLD,15));
        resetMap.setFont(new Font("等线",Font.BOLD,15));
        backToMenu.setBackground(new Color(199, 204, 204));
        resetMap.setBackground(new Color(199, 204, 204));

        backToMenu.addActionListener(e -> {
            MainWindow.menu(mainWindow);
        });
        resetMap.addActionListener(e -> {
            MainWindow.playing(mainWindow,level);
        });

        add(backToMenu);
        add(resetMap);
    }
}
