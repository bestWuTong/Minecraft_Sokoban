package start;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    public InfoPanel(){
        setLayout(new BorderLayout());

        JLabel visionInfo = new JLabel();
        JLabel copyrightInfo = new JLabel();

        visionInfo.setText("我的世界：推箱子  |  版本：1.1.0");
        copyrightInfo.setText("作者：無同  |  网站：www.bestwutong.top");
        visionInfo.setFont(new Font("等线",Font.BOLD,18));
        copyrightInfo.setFont(new Font("等线",Font.BOLD,18));
        visionInfo.setForeground(Color.white);
        copyrightInfo.setForeground(Color.white);

        add(visionInfo, BorderLayout.WEST);
        add(copyrightInfo, BorderLayout.EAST);
    }
//    public Copyright(){
//        setText("版本：2.0   |   作者：無同   |   网站：www.bestwutong.top");
//        setFont(new Font("等线",Font.BOLD,18));
//        setForeground(Color.white);
//    }
}
