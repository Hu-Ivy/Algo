package exercise;

public class Stack_L64 {


    public static void main(String[] args) {
        // int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {1, 1};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res=0;


        return res;
    }
}


