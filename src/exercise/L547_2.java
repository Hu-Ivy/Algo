package exercise;

public class L547_2 {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1, 1, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 1, 1, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 1, 1}
        };

        int[][] isConnected2 = {{
                1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {
                1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {
                0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {
                0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {
                0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}, {
                0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {
                0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0}, {
                1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, {
                0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0}, {
                0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1}, {
                0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {
                0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1}};
        int res = findCircleNum(isConnected2);
        System.out.println(res);
    }

    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UnionFind unionFind = new UnionFind(len);

        for (int i = 0; i < len; i++) {
            // 下标到 i ，并且不能取到，表示只需要看矩阵的下三角部分（不包括对角线）
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    public static class UnionFind {
        /**
         * 每个结点的 id 标识，id 标识一样，表示被分在一个组
         */
        private int[] id;

        /**
         * 连通分量的个数,初始化为N
         */
        private int count;
        private int N;

        public int getCount() {
            return count;
        }

        public UnionFind(int N) {
            this.N = N;
            this.count = N;
            this.id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int find(int x) {
            return id[x];
        }

        public void union(int x, int y) {
            int xid = find(x);
            int yid = find(y);

            // 合并之前先做判断，如果相等，说明已经属于一个圈子，则直接返回不用count--。
            if (xid == yid) {
                return;
            }
            // 这里需要遍历，时间复杂度为 $O(N)$，把属于xid的分量全部赋值为yid。
            for (int i = 0; i < N; i++) {
                if (id[i] == xid) {
                    id[i] = yid;
                }
            }
            //每进行一次合并圈子，圈子数量减少一个。除非是x，y圈子一样，直接return。
            count--;
        }

    }


}
