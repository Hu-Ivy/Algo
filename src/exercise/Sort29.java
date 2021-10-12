package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Sort29 {

    public static void main(String[] args) {

        int[] input = new int[]{2, 3, 1, 0, 2, 5, 3};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(input,2);
        System.out.println(arrayList.toString());
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);

        if (k > input.length) {
            return res;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);

        if (k > input.length||k==0) {
            return res;
        }
        //map中key存放数组中元素，value存放这个元素的个数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count=0;
        for (int i = 0; i < input.length; i++) {
            if (count<k) {
                map.put(input[i],map.getOrDefault(input[i],0) +1);
                count++;

            }
        }


        return res;
    }
}
