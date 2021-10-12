package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numEdges;

    private boolean[] isVisited ;
    public static void main(String[] args) {
        int n = 5;
        String[] vertexs ={"A","B","C","D","E"};

        //创建图对象
        Graph graph= new Graph(n);
        for (String vertex :
                vertexs) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();

        graph.dfs();
    }

    //构造器
    public Graph(int n) {
        // 初始化矩阵和vertexList
        edges=new int[n][n];
        vertexList= new ArrayList<String>(n);
        numEdges = 0;
        isVisited= new boolean[5];
    }
    //如果存在大于0的邻接点，则返回下标
    public int getFirstVertex(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0) {
                return i;
            }
        }
        return -1;
    }
    //返回下一个邻接点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0) {
                return i;
            }
        }
        return -1;
    }
    public int getNumEdges() {
        return numEdges;
    }

    //深度优先
    public void dfs(boolean isVisited[], int i) {
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;

        //第一个邻接点
        int w= getFirstVertex(i);
        while (w!=-1) {
            if (!isVisited[w]) {
                dfs(isVisited,w);
            }
            w=getNextNeighbor(i,w);

        }
    }

    //进行dfs递归
    public void dfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }

    //返回节点下标
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    //插入节点顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numEdges++;
    }

    //显示图
    public void showGraph() {
        for (int[] link :
                edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}
