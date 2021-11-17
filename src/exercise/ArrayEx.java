package exercise;

import java.util.*;
import java.util.Random;

public class ArrayEx {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums1 = {1,5};
        int[] nums2 = {10};
        int numRows = 5;

        List<List<Integer>> res1 = permute(nums);


        System.out.println(res1);
    }

    //L27 移除元素,快慢指针。慢指针指向要被赋值的元素，快指针跳过一样的元素。
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int quick = 0;
        int count = 0;
        while (quick < nums.length) {
            if (nums[quick] == val) {
                quick++;

                continue;
            }
            nums[slow] = nums[quick];
            slow++;
            quick++;
            count++;
        }
        return count;
    }

    //L46 全排列
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len==0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs46(nums, len, 0 ,path, used, res);
        return res;
    }

    /**
     *
     * @param nums  候选数字列表
     * @param len 列表长度，可以直接从 nums.length 里获取，因为需要使用的次数很多，设计这个冗余的变量
     * @param index 当前需要确定的 path 中的元素的下标
     * @param path 已经选择的元素列表
     * @param used 快速判断某个数是否已经被选择
     * @param res 记录结果集的列表
     */
    private static void dfs46(int[] nums, int len, int index, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (index==len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i <len; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            // 在添加 nums[i] 以后输出

            dfs46(nums,len,index+1,path,used,res);

            path.remove(index);
            used[i]=false;
            // 在撤销 nums[i] 以后输出

        }

    }


    //L53 最大子序和，负数对和有负作用，还不如此数本身大，所以全部还原
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    //L179 最大数
//    要想组成最大的整数，一种直观的想法是把数值大的数放在高位。于是我们可以比较输入数组的每个元素的最高位，最高位相同的时候比较次高位，以此类推，完成排序，然后把它们拼接起来。这种排序方式对于输入数组 没有相同数字开头 的时候是有效的，例如 [45, 56, 81, 76, 123][45,56,81,76,123]。
//
//    下面考虑输入数组 有相同数字开头 的情况，例如 [4,42][4,42] 和 [4,45][4,45]。
//
//    对于 [4,42][4,42]，比较 442 > 424 442>424，需要把 44 放在前面；
//    对于 [4,45][4,45]，比较 445 < 454 445<454，需要把 4545 放在前面。
//    因此我们需要比较两个数不同的拼接顺序的结果，进而决定它们在结果中的排列顺序。

    public static String largestNumber(int[] nums) {
        int len = nums.length;
        Integer[] numsArr = new Integer[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr,(x,y)->{
            long sx=10,sy=10;
            while (sx<=x) {
                sx*=10;
            }
            while (sy<=y) {
                sy*=10;
            }
            return (int)(-sy*x-y+sx*y+x);

        });

        if (numsArr[0]==0) {
            return "0";
        }

        for (int i = len-1; i >=0 ; i--) {
            sb.append(numsArr[i]);
        }
        return sb.toString();
    }

    //L198 打家劫舍
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+3];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            dp[i]=0;
        }
        //一定要投i的话，只能偷i-2或者i-3的，所以算一下最大值。期间最大金额即是。
        // 还有一种方法，每个房间有偷与不偷两种选项，偷的话i-2加上要偷的，不偷的话就取i-1，比较一下哪个大。最后返回最后一个数。
        for (int i = 3; i < nums.length+3; i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3])+nums[i-3];
            if (dp[i]>max) {
                max=dp[i];
            }
        }
        return max;
    }
    //JZ51 逆序对
    public static int reversePairs(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        return mergeSort51(nums, 0, len - 1, temp);
    }

    public static int mergeSort51(int[] nums, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left >= right) {
            return 0;
        }
        //注意这里res=子res相加
        int res = mergeSort51(nums, left, mid, temp) + mergeSort51(nums, mid + 1, right, temp);
        int startL = left;
        int startR = mid + 1;
        int index = left;
        while (index <= right) {
            if (startL == mid + 1) {
                temp[index++] = nums[startR++];
            } else if (startR == right + 1 || nums[startL] <= nums[startR]) {
                temp[index++] = nums[startL++];
            } else {
                temp[index++] = nums[startR++];
                res += mid - startL + 1;
            }
        }
        while (left <= right) {
            nums[left] = temp[left];
            left++;
        }
        return res;
    }

    //L118 杨辉三角
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int left = res.get(i - 1).get(j - 1);
                    int right = res.get(i - 1).get(j);
                    temp.add(left + right);
                }
            }
            res.add(temp);
        }
        return res;

    }

    //L119 杨辉三角2  可以用滚动数组优化
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int left = res.get(i - 1).get(j - 1);
                    int right = res.get(i - 1).get(j);
                    temp.add(left + right);
                }
            }
            res.add(temp);
        }
        return res.get(rowIndex);
    }

    //L136 任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
    //任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
    //异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    //L202 快乐数
    public static boolean isHappy(int n) {

        Set<Integer> temp = new HashSet<>();
        while (temp.add(n)) {
            int sum = 0;
            int i = n;
            while (i != 0) {
                sum += (i % 10) * (i % 10);
                i = i / 10;
            }

            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;

    }

    //L215 数组中的第K个最大元素
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSort215(nums, 0, len - 1, len - k);
    }

    private static int quickSort215(int[] nums, int left, int right, int k) {
        //不需要判断是否left<=right了。直接去quicksort靠近k的快排部分。
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == k) return nums[k];
        return pivotIndex < k ? quickSort215(nums, pivotIndex + 1, right, k) : quickSort215(nums, left, pivotIndex - 1, k);
    }


    //L217 存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num :
                nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    //L300 最长递增子序列
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }

            }
            //最后一个不一定是最大数，所以要记录。
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //L485 计算最大连续1的个数
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                if (maxLen < count) {
                    maxLen = count;
                }
                count = 0;
            } else {
                count++;

            }
        }
        if (maxLen < count) {
            maxLen = count;
        }
        return maxLen;
    }

    //283 移动零,双指针法；
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        int quick = 0;
        while (quick < nums.length) {
            if (nums[quick] == 0) {
                quick++;

                continue;
            }
            nums[slow] = nums[quick];
            slow++;
            quick++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //L349 两个数组的交集
    public static int[] intersection(int[] nums1, int[] nums2) {
        int i = 0;
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num :
                nums1) {
            set.add(num);
        }
        for (int num :
                nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int[] intersetction = new int[res.size()];
        int index = 0;
        for (int num :
                res) {
            intersetction[index++] = num;
        }
        return intersetction;
    }

    //L475 供暖器
    public static int findRadius(int[] houses, int[] heaters) {
        int[] dp = new int[houses.length];
        int min=3 * (int)(Math.pow(10,3));
        Arrays.fill(dp,min);
        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < heaters.length; j++) {
                int d = Math.abs(houses[i]-heaters[j]);
                if (d<dp[i]) {
                    dp[i]=d;
                }
            }

        }
        int max=0;
        for (int j : dp) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
    private static int count = 0;

    //494 目标和
    public static int findTargetSumWays(int[] nums, int target) {
        dfs494(nums, target, 0, 0);
        return count;
    }

    public static void dfs494(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs494(nums, target, index + 1, sum + nums[index]);
            dfs494(nums, target, index + 1, sum - nums[index]);
        }
    }

    //L673 最长递增子序列的个数
    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp[0] = 1;
        dp2[0] = 1;

        int ans = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            dp2[i] = 1;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        dp2[i] = dp2[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        dp2[i] += dp2[j];
                    }
                }

            }
            //最后一个不一定是最大数，所以要记录。
            if (dp[i] > max) {
                max = dp[i];
                ans = dp2[i];
            } else if (dp[i] == max) {
                //如果相等就相加。
                ans += dp2[i];
            }

        }
        return ans;
    }

    //L746 使用最小花费爬楼梯
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int d = cost[0];
        int p = cost[1];
        int f;

        for (int i = 2; i < len; i++) {
            f = Math.min(d, p) + cost[i];
            d = p;
            p = f;
        }
        return Math.min(d, p);

    }

    //L781 森林中的兔子
    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < answers.length; i++) {
            if (map.containsKey(answers[i])) {
                int count = map.get(answers[i]) + 1;
                map.put(answers[i], count);
            } else {
                map.put(answers[i], 1);

            }
        }
        Set<Integer> keys = map.keySet();
        //可以用 map.entrySet 遍历map， 以及直接向上取整编号。x+y/(y+1)
        for (int key :
                keys) {
            int count = map.get(key);
            res += (count / (key + 1)) * (key + 1);
            if (count % (key + 1) != 0) {
                res += key + 1;
            }
        }
        return res;

    }


    //L912 归并排序
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left >= right) {
            return;
        }
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int startL = left;
        int startR = mid + 1;
        int index = left;
        while (index <= right) {
            if (startL > mid) {
                temp[index++] = nums[startR++];
            } else if (startR > right) {
                temp[index++] = nums[startL++];
            } else if (nums[startL] <= nums[startR]) {
                temp[index++] = nums[startL++];
            } else {
                temp[index++] = nums[startR++];
            }
        }
        while (left <= right) {
            nums[left] = temp[left];
            left++;
        }
    }

    //L912 快速排序
    public static int[] sortArray2(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }

        }
        swap(nums, left, i);
        return i;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private static void swap(String[] nums, int index1, int index2) {
        String temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
