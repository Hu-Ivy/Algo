package exercise;

import java.util.Arrays;

public class String_L24 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s,t));

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            //已经判断过长度相等了，所以除非有字符小于0，否则两者必相等
            if (table[t.charAt(i) - 'a']<0) {
                return false;
            }
        }


        return true;
    }
}
