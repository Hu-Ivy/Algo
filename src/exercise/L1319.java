package exercise;

public class L1319 {
    public static void main(String[] args) {
        int[][] connections = {{
                0, 1}, {
                0, 2},
                {0, 3}, {
                1, 2}};

        System.out.println(makeConnected(6, connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge :
                connections) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.getCount() - 1;

    }

    /**
     * 为每个节点选出一个代表元素，位于树的根节点。
     */
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
        }

        public int find(int x) {
            //寻找到代表节点，赋值。
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
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

            parent[rootX] = rootY;
            size[rootX] += size[rootY];
            count--;
        }

    }
}
