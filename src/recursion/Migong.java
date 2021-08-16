package recursion;

public class Migong {
    public static void main(String[] args) {
        //1先创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示强的位置，先把上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("---------Result-----------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * map[i][j]=0时没走过，1是强，2是走的通。3已经探测过了。下->右->上->左
     *
     * @param map
     * @param i   从哪个位置开始找
     * @param j
     * @return 有通路到(6, 5)则返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[4][1] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            //假设能走通
            map[i][j] = 2;
            if (setWay(map, i+1, j)) {
                return true;
            } else if (setWay(map, i, j+1)) {
                return true;
            }else if (setWay(map, i-1, j)) {
                return true;
            }else if (setWay(map, i, j-1)) {
                return true;
            }else {
                map[i][j]=3;
                return false;
            }
        }else {
            return false;
        }

    }
}
