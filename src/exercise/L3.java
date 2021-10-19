package exercise;

import java.util.HashSet;
import java.util.Set;

public class L3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "pwwkew";
        int res = lengthOfLongestSubstring(s2);
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLen=1;
        if (s.length()<2) return s.length();

        //记录有没有字幕出现过
        Set<Character> set= new HashSet<>();
        char[] array = s.toCharArray();
        for (int left = 0, right=0; left <s.length()-1; left++) {
            //可以不一个一个收缩，记录重复字符的位置，直接跳到其下一个。
            if (left!=0) {
                set.remove(array[left-1]);
            }
            while (right<s.length()&&!set.contains(array[right])) {
                 set.add(array[right]);
                 right++;
            }
            maxLen=Math.max(maxLen, right-left);
        }
        return maxLen;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int maxLen=1;
        if (s.length()<2) return s.length();

        //记录有没有字幕出现过
        char[] array = s.toCharArray();
        int[] window = new int[128];
        for (int i = 0; i < 128; i++) {
            window[i] = -1;
        }

        int left=0;
        for (int right = 0; right < s.length(); right++) {
            //移动left
            if (window[array[right]]!=-1) {
                left=Math.max(left,window[array[right]]+1);

            }
            //存储right
            window[array[right]]=right;
            maxLen=Math.max(maxLen,right-left+1);
            //移动right
        }
        return maxLen;
    }

}
