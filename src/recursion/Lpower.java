package recursion;

public class Lpower {
    public static void main(String[] args) {
        double res = myPow(2.0,10);
        System.out.println(res);
    }
    public static double myPow(double x, int n) {

        if(n==1) return x;

        return x*myPow(x,n-1);
    }
}
