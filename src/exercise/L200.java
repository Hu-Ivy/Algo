package exercise;

import java.util.Arrays;

public class L200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1','1', '1','0'},
                {'1', '1','0', '1','0'},
                {'1', '1','0', '0','0'},
                {'0', '0','0', '0','0'}};

        int res = numIslands(grid);
        System.out.println(res);
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}};
        int size = rows * cols;
        // 多开一个结点，把 '0' 都与最后这个结点连在一起
        UnionFind unionFind = new UnionFind(size + 1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]=='1') {
                    for (int[] direction :
                            directions) {
                        int newX = i+direction[0];
                        int newY = j+direction[1];
                        //如果新方向的点存在并且也为1，则合并两个点。
                        if (inArea(newX, newY, rows, cols) && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(newX, newY, cols),getIndex(i, j, cols) );
                        }
                    }
                }else {
                    //把属于0的点都归于一类。
                    unionFind.union(getIndex(i, j, cols), size);
                }

            }
        }

        return unionFind.getCount() - 1;
    }
    private static boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private static int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private static class UnionFind {
        /**
         * 在查找的过程中，总是从下到上查找，每个结点的父结点是我们关心的，因此把这个数组命名为 parent
         */
        private int[] parent;
        private int count;
        private int[] size;

        public int getCount() {
            return count;
        }

        public UnionFind(int N) {
            this.size = new int[N];
            this.count = N;
            this.parent = new int[N];
            // 初始化的时候，每个元素指向它自己，即：单独的一个结点是一棵树
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            Arrays.fill(size,1);
        }

        public int find(int x) {
            //寻找到代表节点，赋值。
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            if (size[rootX] == size[rootY]) {
                // 将其中一棵树的根结点指向另一棵树的根结点即可，两个根结点不分彼此
                parent[rootX] = rootY;
                size[rootY] += 1;
            } else if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的子树多了 size[rootX] 这么多结点
                // 需要维护定义
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                // 此时以 rootY 为根结点的子树多了 size[rootX] 这么多结点
                // 需要维护定义
                size[rootX] += size[rootY];
            }
            count--;
        }

    }

}
