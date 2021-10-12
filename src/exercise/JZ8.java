package exercise;

public class JZ8 {
    static int num=0;
    public static void main(String[] args) {

        int res = jumpFloor(3);
        System.out.println(res);

    }

    public static int jumpFloor(int target) {
        if (target==0) num++;
        for (int i = target; i >0 ; i--) {
            jumpFloor(target-i);
        }
        return num;
    }
}
