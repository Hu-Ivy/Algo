package exercise;

public class JZ46 {
    public static void main(String[] args) {
        int res = translateNum(12258);
        System.out.println(res);
    }

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int res = 1;

        int p=0;
        int q=0;

        for (int i = 0; i < s.length(); i++) {
            String two = ""+s.charAt(i-1)+s.charAt(i);

            if (Integer.parseInt(two)<26) {
                res=p+q;
            }

            p=q;
            q=res;
        }
        return res;
    }
}
