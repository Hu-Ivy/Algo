package exercise;

import java.util.Arrays;

public class L76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s,t);
        System.out.println(res);

    }

    public static String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] pattern = new int[128];
        int[] window = new int[128];

        final int A = 'A';
        for (char tChar :
                tChars) {
            pattern[tChar-A]++;
        }
        int distance = 0;

        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                distance++;
            }
        }

        int left=0;
        int right=0;
        int minLen= sChars.length+1;
        int match=0;
        int start = 0;

        while (right<sChars.length) {
            char curChar = sChars[right];

            if (pattern[curChar-A]>0) {
                //如果这个字符在pattern里有就+1
                window[curChar-A]++;
                //如果字符的总数量==pattern总数量，则匹配度+1
                if (window[curChar - A] == pattern[curChar - A]) {
                    match++;
                }
            }
            right++;
            //如果match==distance，distance是有几个相同种类的字符，left右移直到不符合
            while (match==distance) {
                //记录符合条件的最小窗口
                if (right-left<minLen) {
                    start=left;
                    minLen=right-left;
                }
                char leftChar = sChars[left];
                if (pattern[leftChar-A]>0) {
                    window[leftChar-A]--;
                    if (window[leftChar-A]<pattern[leftChar-A]) {
                        match--;
                    }
                }
                left++;
            }
        }



        return minLen == sChars.length + 1 ? "" : s.substring(start, start + minLen);
    }
}
