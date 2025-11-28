package window;

import menu.MenuBackground;
import menu.MenuButtonPanel;
import menu.MenuTittlePanel;
import menu.MenuTopMenu;
import playing.GameMap;
import playing.GameTopMenu;
import playing.MapPanel;
import start.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    final int windowWidth = 1280;   //窗口宽度
    final int windowHeight = 750;   //窗口高度

    public MainWindow() {
        setTitle("我的世界：推箱子");
        setBounds((screenWidth-windowWidth)/2,
                (screenHeight-windowHeight)/2,
                windowWidth,windowHeight);
        setResizable(false);    //窗口不可调整大小
        // 窗口图标
        java.net.URL iconUrl = MainWindow.class.getResource("/img/icon.png");
        ImageIcon windowIcon = null;
        if (iconUrl != null) {
            windowIcon = new ImageIcon(iconUrl);
            setIconImage(windowIcon.getImage());//设置窗口图标
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //开始界面
    public static void start(MainWindow mainWindow){
        cleanWindow(mainWindow);
        mainWindow.setTitle("我的世界：推箱子");
        mainWindow.setVisible(true);

        int contentWidth = mainWindow.getContentPane().getWidth();//窗口内容宽度
        int contentHeight = mainWindow.getContentPane().getHeight();//窗口内容高度

        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0, 0, contentWidth, contentHeight);
        JPanel backGroundPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);//面板透明
        backGroundPanel.setBounds(0, 0, contentWidth, contentHeight);
        topPanel.setBounds(0, 0, contentWidth, contentHeight);

        //背景面板
        StartBackground startBackground = new StartBackground(mainWindow);
        startBackground.setBorder(BorderFactory.createEmptyBorder(
                0, 0, 0, 0));
        //Logo面板
        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false);//面板透明
        logoPanel.setBorder(BorderFactory.createEmptyBorder(
                contentHeight/10, 0, 0, 0));
        StartLogo startLogo = new StartLogo(mainWindow);
        //按钮面板
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
        btnPanel.setOpaque(false);//面板透明
        btnPanel.setBorder(BorderFactory.createEmptyBorder(
                contentHeight/5, (contentWidth-250)/2,
                0, (contentWidth-250)/2));
        StartButton startButton = new StartButton(mainWindow);
        ExitButton exitButton = new ExitButton(mainWindow);
        //底部信息面板
        InfoPanel infoPanel = new InfoPanel();
        infoPanel.setOpaque(false);//面板透明
        infoPanel.setBorder(BorderFactory.createEmptyBorder(
                0, 10, 10, 10));

        mainWindow.add(jLayeredPane, BorderLayout.CENTER);
        jLayeredPane.add(backGroundPanel, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(topPanel, JLayeredPane.DRAG_LAYER);
        backGroundPanel.add(startBackground);
        topPanel.add(logoPanel, BorderLayout.NORTH);
        topPanel.add(btnPanel, BorderLayout.CENTER);
        topPanel.add(infoPanel, BorderLayout.SOUTH);
        logoPanel.add(startLogo);
        btnPanel.add(startButton);
        btnPanel.add(exitButton);

        System.out.println("已进入开始界面..."); //调试用
        mainWindow.setVisible(true);
    }
    //关卡目录
    public static void menu(MainWindow mainWindow){
        cleanWindow(mainWindow);
        mainWindow.setTitle("我的世界：推箱子");
        mainWindow.setVisible(true);

        int contentWidth = mainWindow.getContentPane().getWidth();//窗口内容宽度
        int contentHeight = mainWindow.getContentPane().getHeight();//窗口内容高度

        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0, 0, contentWidth, contentHeight);
        JPanel backGroundPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);//面板透明
        backGroundPanel.setBounds(0, 0, contentWidth, contentHeight);
        topPanel.setBounds(0, 0, contentWidth, contentHeight);

        //背景面板
        MenuBackground menuBackground = new MenuBackground(mainWindow);
        menuBackground.setBorder(BorderFactory.createEmptyBorder(
                0, 0, 0, 0));
        //标题面板
        MenuTittlePanel menuTittlePanel = new MenuTittlePanel(mainWindow);
        menuTittlePanel.setOpaque(false);//面板透明
        //关卡按钮面板
        MenuButtonPanel menuButtonPanel = new MenuButtonPanel(mainWindow);
        menuButtonPanel.setOpaque(false);//面板透明
        //窗口菜单栏
        MenuTopMenu menuTopMenu = new MenuTopMenu(mainWindow);
        mainWindow.setJMenuBar(menuTopMenu);

        mainWindow.add(jLayeredPane, BorderLayout.CENTER);
        jLayeredPane.add(backGroundPanel, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(topPanel, JLayeredPane.DRAG_LAYER);
        backGroundPanel.add(menuBackground);
        topPanel.add(menuTittlePanel, BorderLayout.NORTH);
        topPanel.add(menuButtonPanel, BorderLayout.CENTER);

        System.out.println("已进入关卡目录..."); //调试用
        mainWindow.setVisible(true);
    }
    //游戏页面
    public static void playing(MainWindow mainWindow,int level){
        cleanWindow(mainWindow);
        mainWindow.setTitle("我的世界：推箱子   |   第 " + level + " 关");

        int contentWidth = mainWindow.getContentPane().getWidth();//窗口内容宽度
        int contentHeight = mainWindow.getContentPane().getHeight();//窗口内容高度

        //游戏地图
        GameMap gameMap = new GameMap(level);
        //游戏区域
        MapPanel mapPanel = new MapPanel(mainWindow,gameMap);
        mapPanel.setBounds(0, 0, contentWidth, contentHeight);
        mainWindow.add(mapPanel);
        //窗口菜单栏
        GameTopMenu gameTopMenu = new GameTopMenu(mainWindow,level);
        mainWindow.setJMenuBar(gameTopMenu);

        System.out.println("已进入游戏页面..."); //调试用
        mainWindow.setVisible(true);
    }

    public static void cleanWindow(MainWindow mainWindow){
        //清除窗口内对象
        mainWindow.getContentPane().removeAll();
        //清除菜单栏
        mainWindow.setJMenuBar(null);

        System.out.println("已初始化窗口"); //调试用
    }

    //获取屏幕宽度和高度
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
//    //窗口宽度和高度
//    int windowWidth = screenWidth/5*4;
//    int windowHeight = screenHeight/5*4;

}
