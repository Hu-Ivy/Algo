package recursion;

public class EightQueen {
    int max=8;
    int[] arr = new int[max];
    static int count=0;
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);

        System.out.println("---------------");
        System.out.println(count);
    }
    private void check(int n) {
        if (n==max) {
            print();
            count++;
            return;
        }
        //依次放入皇后并判断是否冲突,i为列
        for (int i = 0; i < max; i++) {
            //先放到该行第一列
            arr[n] = i;
            if (judge(n)) {
                check(n+1);
            }
        }
    }
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i]== arr[n]||n-i==Math.abs(arr[n]-arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int j : arr) {
            System.out.print(j);
        }
        System.out.println();
    }
}


