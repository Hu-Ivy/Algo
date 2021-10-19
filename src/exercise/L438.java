package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> res = findAnagrams(s, p);
        System.out.println(res.toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] pattern = new int[26];
        int[] window = new int[26];
        final int A = 'a';

        for (int i = 0; i < p.length(); i++) {
            pattern[p.charAt(i) - A]++;
        }

        int left = 0;
        int right = 0;


        while (right < s.length()) {
            char curChar = s.charAt(right);
            window[curChar-A]++;

            //当频数超过时，减去，否则当频数没有超过且长度一样时，为一个位置。
            while (window[curChar-A]>pattern[curChar-A]) {
                int curLeft = s.charAt(left);
                window[curLeft-A]--;
                left++;

            }
            if(right - left + 1 == p.length()){
                res.add(left);
            }
            right++;

        }
        return res;
    }
}
