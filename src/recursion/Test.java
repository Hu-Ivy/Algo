package recursion;

public class Test {
    public static void main(String[] args) {
        System.out.println(factorial(4));

        int a = 1;
        int b= a;
        b=2;
        System.out.println(b);
    }

    public static void test(int n){
        if (n>2){
            test(n-1);
        }else {
            System.out.println(n);
        }
    }
    public static int factorial(int n) {
        if (n==1) {
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }
}
