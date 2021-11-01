package exercise;

import java.util.*;

public class L56 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2, 3,4},
                {4, 0, 6,4},
                {7, 8, 9,4},
        };

//        int[][] res = merge(intervals);
//        for (int[] interval :
//                intervals) {
//            System.out.println(Arrays.toString(interval));
//        }
//        for (int[] r :
//                res) {
//            System.out.println(Arrays.toString(r));
//        }
//        rotate(intervals);
//        setZeroes(intervals);
        int[] res = findDiagonalOrder(intervals);
//        for (int[] interval :
//                intervals) {
//            System.out.println(Arrays.toString(interval));
//        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();

        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void rotate(int[][] matrix) {
        //先水平轴翻转，再对角线轴翻转。
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        //对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    //L73
    public static void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> lines = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    lines.add(j);
                }
            }
        }

        for (int row : rows
        ) {
            Arrays.fill(matrix[row], 0);
        }

        for (int line : lines
        ) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[i][line] = 0;
            }
        }
    }

    //498
    public static int[] findDiagonalOrder(int[][] matrix) {
        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            //记录行和列的起始位置
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // 读取对角线数据
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // 是否翻转读取
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }
            //读取临时存储数据。
            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;

    }
}
