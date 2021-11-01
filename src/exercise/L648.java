package exercise;

import java.util.Arrays;

public class L648 {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1, 4}, {3,4}, {1,3}, {1,2}, {4,5}};
        int[] res = findRedundantConnection(isConnected);
        System.out.println(Arrays.toString(res));

    }
    public static int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge :
                edges) {
            int i = edge[0]-1;
            int j = edge[1]-1;
            boolean temp = unionFind.union(i,j);
            if (temp) {
                res[0]=i+1;
                res[1]=j+1;
                break;
            }

        }
        return res;
    }

    public static class UnionFind {
        private final int[] parent;
        private final int[] size;
        public UnionFind(int N) {
            this.parent = new int[N];
            this.size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            Arrays.fill(size,0);
        }

        public int find(int x) {
            if (x!=parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public boolean union(int x, int y) {
            int[] res = new int[2];

            int rootX = find(x);
            int rootY = find(y);

            parent[rootX] = rootY;

            return rootX==rootY;
        }
    }
}
