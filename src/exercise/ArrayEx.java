package exercise;

import java.util.*;
import java.util.Random;

public class ArrayEx {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        int numRows = 5;
//        int res = removeElement(nums,2);
//        int res = findMaxConsecutiveOnes(nums);

//        List<List<Integer>> res = generate(numRows);
//        List<Integer> res = getRow(3);

//        moveZeroes(nums);
//        boolean res = isHappy(19);
        //L912
//        int[] res = sortArray2(nums);
        //JZ51 数组中的逆序对
        int res = reversePairs(nums);
        System.out.println(res);
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
        int res = mergeSort51(nums, left, mid, temp)+mergeSort51(nums, mid + 1, right, temp);
        int startL = left;
        int startR = mid + 1;
        int index = left;
        while (index <= right) {
            if (startL==mid+1) {
                temp[index++]=nums[startR++];
            }else if (startR==right+1||nums[startL]<=nums[startR]) {
                temp[index++]=nums[startL++];
            }else {
                temp[index++]=nums[startR++];
                res += mid-startL+1;
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
        return quickSort215(nums, 0, len-1,len-k);
    }
    private static int quickSort215(int[] nums, int left, int right,int k) {
        //不需要判断是否left<=right了。直接去quicksort靠近k的快排部分。
        int pivotIndex = partition(nums,left,right);
        if (pivotIndex==k) return nums[k];
        return pivotIndex<k?quickSort215(nums,pivotIndex+1,right,k):quickSort215(nums,left,pivotIndex-1,k);
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
        quickSort(nums, 0, len-1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left>=right) return;
        int pivotIndex = partition(nums,left,right);
        quickSort(nums,left,pivotIndex-1);
        quickSort(nums,pivotIndex+1,right);
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int i = left;
        int j = right;

        while (i<j) {
            while (i<j&&nums[j]>=nums[left]) {
                j--;
            }
            while (i<j&&nums[i]<=nums[left]) {
                i++;
            }
            if (i<j){
                swap(nums,i,j);
            }

        }
        swap(nums,left,i);
        return i;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
