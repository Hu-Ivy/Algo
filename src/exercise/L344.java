package exercise;

import java.util.Arrays;

public class L344 {
    public static void main(String[] args) {
        char[] s = {'h','e','i','i','o'};

        reverseString(s);

        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }

    public static void reverse(char[] s, int left, int right) {
        char temp;
        if (left>=right) {
            return;
        }
        temp=s[left];
        s[left]=s[right];
        s[right]=temp;

        reverse(s,left+1,right-1);
    }
}
