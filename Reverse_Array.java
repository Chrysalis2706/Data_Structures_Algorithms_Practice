import java.util.Arrays;

public class Reverse_Array {
    public static void reverse_array(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1 , 4, 5, 8, 10};
        reverse_array(arr);
        System.out.println(Arrays.toString(arr));
    }
}
