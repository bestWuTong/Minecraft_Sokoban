package playing;

//当前地图状态
public class GameMap {
    //地图数组 数据含义
    //0：地板
    //1：墙体
    //2：玩家
    //3：箱子
    //当目标位置都=3时通关
    private static final int levelNumber = 6;     //总关卡数
    private int level;                //当前关卡
    private int[][] mapData;          //地图数据
    private int[] playerPlace;        //玩家当前位置
    private int[][] targetPlace;      //目标位置
    private int rows;                 //地图行数
    private int cols;                 //地图列数

    public GameMap() {
    }
    public GameMap(int level) {
        this.level = level;
        this.setMapData();
    }

    public static int getLevelNumber() {
        return levelNumber;
    }

    public int getLevel() {
        return level;
    }

    public int[][] getMapData() {
        return mapData;
    }
    public void setMapData() {
        switch (this.level){
            case 1:
                this.mapData = new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 3, 2, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1}
                };
                this.playerPlace = new int[] {2,7};
                this.targetPlace = new int[][] { {2,1} };
                this.rows = 5;
                this.cols = 9;
                break;
            case 2:
                this.mapData = new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 1, 2, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 3, 3, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
                this.playerPlace = new int[] {3,8};
                this.targetPlace = new int[][] { {4,8}, {5,7}, {5,8} };
                this.rows = 9;
                this.cols = 16;
                break;
            case 3:
                this.mapData = new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
                this.playerPlace = new int[] {4,8};
                this.targetPlace = new int[][] { {3,7}, {3,9}, {5,7}, {5,9} };
                this.rows = 9;
                this.cols = 16;
                break;
            case 4:
                this.mapData = new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 3, 3, 3, 3, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
                this.playerPlace = new int[] {2,5};
                this.targetPlace = new int[][] { {2,7}, {2,8}, {3,7}, {3,8} };
                this.rows = 9;
                this.cols = 16;
                break;
            case 5:
                this.mapData = new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 3, 0, 3, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 3, 1, 3, 3, 3, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 3, 0, 3, 2, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
                this.playerPlace = new int[] {5, 10};
                this.targetPlace = new int[][] {{2, 5}, {2, 6}, {3, 5},
                        {3, 6}, {5, 5}, {5, 6}, {6, 5}, {6, 6}};
                this.rows = 9;
                this.cols = 16;
                break;
            case 6:
                this.mapData = new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1, 3, 1, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 3, 0, 0, 1, 2, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 3, 3, 1, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
                this.playerPlace = new int[] {4, 10};
                this.targetPlace = new int[][] {{2, 5}, {2, 6},
                        {4, 5}, {5, 5}, {5, 6}};
                this.rows = 9;
                this.cols = 16;
                break;
        }
        System.out.println("已初始化地图数据"); //调试用
    }
    public void resetMapData(int[][] mapData){
        this.mapData = mapData;
    }

    public int[] getPlayerPlace() {
        return playerPlace;
    }
    public void setPlayerPlace(int[] playerPlace) {
        this.playerPlace = playerPlace;
    }

    public int[][] getTargetPlace() {
        return targetPlace;
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

}
