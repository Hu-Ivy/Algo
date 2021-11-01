package exercise;

public class L547 {
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
        int res = findCircleNum(isConnected);
        System.out.println(res);
    }

    public static int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public static void union(int[] parent, int index1, int index2) {
        //找到index1归属的开始节点，改变那个头结点的值为新的index2的头节点。
        int index = find(parent, index1);
        //头节点的值等于index2 头结点的值。如果最后突然改变头节点值，例如index1群的头节点改变了，说明它所在的群都属于另一个群，小弟没改变也无所谓，老大变了就行。不相等的话也不会计数。
        parent[index] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        //递归；如果parent[index] != index，一直递归到相等，并把头节点的值带回来并且改变该路径上所有节点的所属类。因为每次union头节点可能会改变，需要重新赋值。
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
