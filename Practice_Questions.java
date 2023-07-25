import com.sun.source.tree.BreakTree;

public class Practice_Questions {
    public static int max_sub_arr(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int cur_sum = 0;

        for (int i=0; i<n; i++){
            cur_sum = 0;
            for (int j=i; j<n; j++){
                cur_sum += arr[j];
                max = Math.max(max, cur_sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(max_sub_arr(arr));
    }
}


