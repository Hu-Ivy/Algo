package dynamic;

import java.util.Arrays;

public class bag {
    public static void main(String[] args) {
        int[] weight = {1,4,3};
        int[] value = {1500,3000,2000};

        int m=4;
        int n = value.length;

        int[][] vector =new int[n+1][m+1];
        int[][] path =new int[n+1][m+1];
        int good=0;
        int bagW=0;
        for (int i = 0; i < vector.length; i++) {
            vector[i][0]=0;
        }
        Arrays.fill(vector[0], 0);

        //动态规划了
        for (int i = 1; i < vector.length; i++) {
            for (int j = 1; j < vector[0].length; j++) {
                if (weight[i-1]>j) {
                    vector[i][j]= vector[i-1][j];
                }else {
                    if (vector[i-1][j- weight[i-1]]+value[i-1]>vector[i-1][j]) {
                        vector[i][j] = vector[i-1][j- weight[i-1]]+value[i-1];
                        path[i][j]=1;
                        good=i;
                        bagW=j;
                    }else {
                        vector[i][j]=vector[i-1][j];
                    }

                }
            }
        }

        //输出
        for (int[] ints : vector) {
            for (int j = 0; j < vector[0].length; j++) {
                System.out.print(ints[j]+"  ");
            }
            System.out.println();
        }

//        for (int[] ints : path) {
//            for (int j = 0; j < path[0].length; j++) {
//                System.out.print(ints[j]+"  ");
//            }
//            System.out.println();
//        }
        int i= vector.length-1;
        int j = vector[0].length-1;
        while (i>0 && j>0) {
            if (path[i][j]==1) {
                System.out.println(String.format("第%d个商品放入了背包中", i));
                j-=weight[i-1];

            }
            i--;
        }
    }


}
