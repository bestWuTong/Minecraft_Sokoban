package menu;

import window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MenuBackground extends JLabel {
    public MenuBackground(MainWindow mainWindow){
        int contentHeight = mainWindow.getContentPane().getHeight();//窗口内容高度
        URL imgURL = MainWindow.class.getResource("/img/menu/MenuBackground.png");
        ImageIcon imageIcon = new ImageIcon(imgURL);
        Image scaledImage = imageIcon.getImage().getScaledInstance(
                (int) (contentHeight*1.778), contentHeight,
                Image.SCALE_SMOOTH
        );
        setIcon(new ImageIcon(scaledImage));
    }
}
