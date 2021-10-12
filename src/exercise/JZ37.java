package exercise;

public class JZ37 {
    public static void main(String[] args) {
        int[] array = {3};
        int num = GetNumberOfK(array,3);

        System.out.println(num);
    }
    public static int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0) return 0;
        int left=0,right=array.length-1;
        int mid = 0;
        int count =0;
        while (left<right) {
            mid = (left+right)/2;
            if (array[mid] <k) {
                left=mid+1;
            }else if(array[mid]>k) {
                right=mid-1;

            }else {
                break;
            }


        }
        for (int i = left; i <= right ; i++) {
            if (array[i]==k) {
                count++;
            }
        }

        return count;
    }
}
