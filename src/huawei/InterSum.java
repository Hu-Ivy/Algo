package huawei;

public class InterSum {
    public static void main(String[] args) {
        int[] nums = {1,100000,2};
        int size = 3;

        areaSum(size,nums);

    }

    public static void areaSum(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            int max = arr[i];
            int min = arr[i];
            int area;

            for (int j = i+1; j < n; j++) {
                //i固定，右子区间扩大时，max，min记录最大最小值。
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);

                area = (max-min)*(j-i+1)%1000000007;
                sum = (sum+area) % 1000000007;
            }

        }
        System.out.println(sum);



    }
}
