package exercise;

import java.util.ArrayDeque;
import java.util.Deque;

public class L42 {
    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);

        System.out.println(res);
    }
    //单调栈法
    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = height.length;
        if (len<3) return 0;

        int area = 0;

        for (int i = 0; i < len; i++) {
            //后压入的大于top则弹出计算面积
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]) {
                int top = stack.pop();
                //弹出左边后如果栈为空，则没有面积可以计算了，直接跳出循环寻找下一个凹槽。
                if (stack.isEmpty()) {
                    break;
                }
                //算距离
                int distance = i-stack.peek()-1;
                int boundedHeight = Math.min(height[i],height[stack.peek()])-height[top];

                area +=distance*boundedHeight;
            }

            stack.push(i);
        }


        return area;
    }

    //双指针法
    public static int trap2(int[] height) {
        int len = height.length;
        if (len<3) return 0;

        int area = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        //左指针右移的终止条件是找到比 rightmax 大的 leftmax，也就是说一旦左指针终止左移，此时的height[left] 一定是 leftmax，且大于 rightmax。
        // 同理，右指针左移的终止条件是找到比 leftmax 大的 rightmax，而此时的 height[right] 就是 rightmax。
        // 所以这里 height[left] < height[right] 中的 height[right] 就是当前的 rightmax，而 height[left] < height[right]（rightmax）
        // 意味着还没找到大于 rightmax 的 leftmax，所以 leftmax < rightmax

        //接水量跟较高的柱子有关，移动一边的时候，另一边正好保持在最大值。
        //保持一边最大值，此时左边一定能接水，每根柱子的接水量为左最大值-左边当前柱子。同理右边最大值没有比左边大的话，移动右边柱子计算蓄水量。直到两个指针相遇。
        //从左向右逐渐寻找最大的挡板，在右边处找到，则左边能蓄水。续到比最大挡板要大于等于的时候，右边移动接着蓄水。
        while (left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left]<height[right]) {
                area += leftMax-height[left];
                left++;
            }else {
                area += rightMax-height[right];
                right--;
            }

        }
        return area;
    }
}
