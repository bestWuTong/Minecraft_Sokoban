package start;

import window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class ExitButton extends JButton {
    public ExitButton(MainWindow mainWindow){
        setText("退 出 游 戏");
        setPreferredSize(new Dimension(200,50));
        setFont(new Font("微软雅黑",Font.BOLD,20));
        setForeground(Color.white);
        setBackground(new Color(152, 26, 26));
        setFocusPainted(false);     //去掉焦点框
        addActionListener(e -> {
            mainWindow.dispose();//释放资源
            System.exit(0);//退出程序
        });
    }
}
