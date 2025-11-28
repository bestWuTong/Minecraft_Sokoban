package playing.engine;

import playing.GameMap;
import playing.MapPanel;
import window.MainWindow;

import javax.swing.*;

public class Engine {
    private MainWindow mainWindow;
    private GameMap gameMap;
    private MapPanel mapPanel;

    public Engine(MainWindow mainWindow, GameMap gameMap, MapPanel mapPanel){
        this.mainWindow = mainWindow;
        this.gameMap = gameMap;
        this.mapPanel = mapPanel;
    }

    public void keyPress(String key){
        control(key);
        mapPanel.showMap(gameMap);

        if (checkPass()) {//显示弹窗
            System.out.println("检测到通关"); //调试用
            showPopups();
        }
    }

    public boolean checkPass(){
        boolean pass = true;
        int[][] targetPlace = gameMap.getTargetPlace();
        for (int i = 0; i < targetPlace.length; i++) {
            int m = targetPlace[i][0];
            int n = targetPlace[i][1];
            if (gameMap.getMapData()[m][n] != 3){
                pass = false;
            }
        }
        return pass;
    }

    public void showPopups(){
        String[] buttons = {"返回主菜单", "返回关卡目录", "下一关"};

        int choice = JOptionPane.showOptionDialog(
                mainWindow,                          //父窗口
                "恭喜过关！",                         //弹窗消息
                "提示",                              //弹窗标题
                JOptionPane.DEFAULT_OPTION,         //选项类型
                JOptionPane.INFORMATION_MESSAGE,    //消息类型
                null,                               //自定义图标
                buttons,                            //自定义按钮文本数组
                buttons[2]                          //默认选中的按钮
        );
        switch (choice) {
            case 0:
                MainWindow.start(mainWindow);
                break;
            case 1:
                MainWindow.menu(mainWindow);
                break;
            case 2:
                int nextLevel = gameMap.getLevel() + 1;
                if (nextLevel <= GameMap.getLevelNumber()){
                    MainWindow.playing(mainWindow,nextLevel);
                }else {
                    showPopups2();
                }
                break;
            case JOptionPane.CLOSED_OPTION: //关闭弹窗
                MainWindow.start(mainWindow);
                break;
            default:
                break;
        }
    }

    public void showPopups2(){
        String[] buttons2 = {"返回主菜单", "返回关卡目录"};

        int choice2 = JOptionPane.showOptionDialog(
                mainWindow,                          //父窗口
                "已经是最后一关了！",                  //弹窗消息
                "提示",                              //弹窗标题
                JOptionPane.DEFAULT_OPTION,         //选项类型
                JOptionPane.INFORMATION_MESSAGE,    //消息类型
                null,                               //自定义图标
                buttons2,                           //自定义按钮文本数组
                buttons2[1]                         //默认选中的按钮
        );
        switch (choice2) {
            case 0:
                MainWindow.start(mainWindow);
                break;
            case 1:
                MainWindow.menu(mainWindow);
                break;
            case JOptionPane.CLOSED_OPTION: //关闭弹窗
                MainWindow.start(mainWindow);
                break;
            default:
                break;
        }
    }

    public void control(String key) {
        int[][] mapData = gameMap.getMapData();
        //玩家坐标[m][n]
        int m = gameMap.getPlayerPlace()[0];
        int n = gameMap.getPlayerPlace()[1];

        switch (key){
            case "UP"://向上
                if (m > 0 && mapData[m-1][n] != 1){//不在边界且上方不是墙
                    if (mapData[m-1][n] == 0){//上方是地板
                        mapData[m-1][n] = 2;
                        mapData[m][n] = 0;
                        --m;
                    }else if (mapData[m-1][n] == 3 && mapData[m-2][n] == 0){//上方是箱子且上上方是地板
                        mapData[m-2][n] = 3;
                        mapData[m-1][n] = 2;
                        mapData[m][n] = 0;
                        --m;
                    }
                }
                break;
            case "LEFT":
                if (n > 0 && mapData[m][n-1] != 1){//不在边界且左方不是墙
                    if (mapData[m][n-1] == 0){//左方是地板
                        mapData[m][n-1] = 2;
                        mapData[m][n] = 0;
                        --n;
                    }else if (mapData[m][n-1] == 3 && mapData[m][n-2] == 0){//左方是箱子且左左方是地板
                        mapData[m][n-2] = 3;
                        mapData[m][n-1] = 2;
                        mapData[m][n] = 0;
                        --n;
                    }
                }
                break;
            case "DOWN":
                if (m < mapData.length - 1 && mapData[m+1][n] != 1){//不在边界且下方不是墙
                    if (mapData[m+1][n] == 0){//下方是地板
                        mapData[m+1][n] = 2;
                        mapData[m][n] = 0;
                        ++m;
                    }else if (mapData[m+1][n] == 3 && mapData[m+2][n] == 0){//下方是箱子且下下方是地板
                        mapData[m+2][n] = 3;
                        mapData[m+1][n] = 2;
                        mapData[m][n] = 0;
                        ++m;
                    }
                }
                break;
            case "RIGHT":
                if (n < mapData[0].length - 1 && mapData[m][n+1] != 1){//不在边界且右方不是墙
                    if (mapData[m][n+1] == 0){//右方是地板
                        mapData[m][n+1] = 2;
                        mapData[m][n] = 0;
                        ++n;
                    }else if (mapData[m][n+1] == 3 && mapData[m][n+2] == 0){//右方是箱子且右右方是地板
                        mapData[m][n+2] = 3;
                        mapData[m][n+1] = 2;
                        mapData[m][n] = 0;
                        ++n;
                    }
                }
                break;
            default:
                break;
        }
        System.out.println("已更新游戏地图"); //调试用
        int[] temp = {m,n};
        gameMap.setPlayerPlace(temp);//更新玩家位置
        gameMap.resetMapData(mapData);//更新地图
    }

}
