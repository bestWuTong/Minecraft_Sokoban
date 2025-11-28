package start;

import window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class StartLogo extends JLabel {
    public StartLogo(MainWindow mainWindow){
        java.net.URL imgUrl = this.getClass().getResource("/img/start/StartLogo.png");
        ImageIcon img = new ImageIcon(imgUrl);
        Image scaledImage = img.getImage().getScaledInstance(
                mainWindow.getWidth()/3,
                (int) ((double) mainWindow.getWidth()/3*0.33),
                Image.SCALE_SMOOTH
        );
        setIcon(new ImageIcon(scaledImage));
    }
}
