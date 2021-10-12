package binarySearch;

public class HanNuoTa {

    public static void main(String[] args) {
        HanTower(3,'A','B','C');
    }

    public static void HanTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num==1) {
            System.out.println("第1个盘从"+a+"->"+c);
        } else {
            //看成两部分，最下面一部分，剩余一部分
            //剩余的n-1部分，从a->b
            HanTower(num-1,a,c,b);
            //最后一个从a->c
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //B上的经过A再到C，由此完成B->C
            HanTower(num-1,b,a,c);
        }
    }
}
