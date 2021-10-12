package exercise;

public class L326 {
    public static void main(String[] args) {
        boolean res = isPowerOfThree(40);
        System.out.println(res);
    }

    public static boolean isPowerOfThree(int n) {
        if (n%4!=0) return false;
        if (n<4) return n==1;

        return isPowerOfThree(n/4);
    }
}
