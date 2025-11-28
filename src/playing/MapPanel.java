package playing;

import playing.engine.Engine;
import playing.engine.KeyboardListening;
import window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class MapPanel extends JPanel {
    private int panelRows;
    private int panelCols;
    private int[][] mapData;
    private Image floorImg;
    private Image wallImg;
    private Image playerImg;
    private Image chestImg;
    private Image targetOnFloorImg;
    private Image targetOnPlayerImg;
    private Image targetOnChestImg;
    private JLabel[][] labels;
    private Engine engine;
    private KeyboardListening keyboardListening;

    public MapPanel(MainWindow mainWindow, GameMap gameMap){
        panelRows = gameMap.getRows();
        panelCols = gameMap.getCols();
        mapData = gameMap.getMapData();

        GridLayout grid = new GridLayout(panelRows,panelCols);
        setLayout(grid);

        int imgWidth = mainWindow.getContentPane().getWidth()/panelCols;
        int imgHeight = mainWindow.getContentPane().getHeight()/panelRows;

        java.net.URL floorImgUrl = this.getClass().getResource("/img/playing/Floor.png");
        java.net.URL wallImgUrl = this.getClass().getResource("/img/playing/Wall.png");
        java.net.URL playerImgUrl = this.getClass().getResource("/img/playing/Player.png");
        java.net.URL chestImgUrl = this.getClass().getResource("/img/playing/Chest.png");
        java.net.URL targetOnFloorImgUrl = this.getClass().getResource("/img/playing/TargetOnFloor.png");
        java.net.URL targetOnPlayerImgUrl = this.getClass().getResource("/img/playing/TargetOnPlayer.png");
        java.net.URL targetOnChestImgUrl = this.getClass().getResource("/img/playing/TargetOnChest.png");
        floorImg = (new ImageIcon(floorImgUrl))
                .getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        wallImg = (new ImageIcon(wallImgUrl))
                .getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        playerImg = (new ImageIcon(playerImgUrl))
                .getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        chestImg = (new ImageIcon(chestImgUrl))
                .getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        targetOnFloorImg = (new ImageIcon(targetOnFloorImgUrl))
                .getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        targetOnPlayerImg = (new ImageIcon(targetOnPlayerImgUrl))
                .getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        targetOnChestImg = (new ImageIcon(targetOnChestImgUrl))
                .getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);

        labels = new JLabel[panelRows][panelCols];
        for (int i = 0; i < panelRows; i++) {
            for (int j = 0; j < panelCols; j++) {
                labels[i][j] = new JLabel();
                add(labels[i][j]);
            }
        }
        showMap(gameMap);

        engine = new Engine(mainWindow,gameMap,this);

        keyboardListening = new KeyboardListening();
        keyboardListening.setEngine(engine);

        // 确保在EDT线程中请求焦点，且组件已显示
        setFocusable(true);
        SwingUtilities.invokeLater(() -> {
            requestFocusInWindow();
            System.out.println("MapPanel请求焦点"); // 调试用
        });
        addKeyListener(keyboardListening);

        // 额外：监听窗口激活，重新请求焦点
        mainWindow.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                requestFocusInWindow();
                System.out.println("MapPanel重新请求焦点"); // 调试用
            }
            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("MapPanel失去焦点"); // 调试用
            }
        });
    }

    public boolean ifTarget(GameMap gameMap,int x,int y){
        boolean result = false;
        int[][] targetPlace = gameMap.getTargetPlace();
        for (int i = 0; i < targetPlace.length; i++) {
            int m = targetPlace[i][0];
            int n = targetPlace[i][1];
            if (m == x && n == y){
                result = true;
            }
        }
        return result;
    }

    public void showMap(GameMap gameMap){
        for (int i = 0; i < this.panelRows; i++) {
            for (int j = 0; j < panelCols; j++) {
                switch (mapData[i][j]) {
                    case 0://地板
                        if (this.ifTarget(gameMap,i,j))
                            labels[i][j].setIcon(new ImageIcon(targetOnFloorImg));
                        else
                            labels[i][j].setIcon(new ImageIcon(floorImg));
                        break;
                    case 1://墙体
                        labels[i][j].setIcon(new ImageIcon(wallImg));
                        break;
                    case 2://玩家
                        if (this.ifTarget(gameMap,i,j))
                            labels[i][j].setIcon(new ImageIcon(targetOnPlayerImg));
                        else
                            labels[i][j].setIcon(new ImageIcon(playerImg));
                        break;
                    case 3://箱子
                        if (this.ifTarget(gameMap,i,j))
                            labels[i][j].setIcon(new ImageIcon(targetOnChestImg));
                        else
                            labels[i][j].setIcon(new ImageIcon(chestImg));
                        break;
                }
            }
        }
        System.out.println("已刷新地图贴图"); //调试用
    }

}
