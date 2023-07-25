import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Sorting_InbuiltSort {



    public static void main(String[] args) {

        int[] arr = {5, 4, 1, 3, 2};

//        Arrays.sort(arr);
//        print_array(arr);

        Arrays.sort(arr, 0, 4); // toindex is NOT INCLUSIVE
        print_array(arr);

        Integer[] arr2 = {24,3 ,32 ,34};
        Arrays.sort(arr2, Collections.reverseOrder());

    }

    private static void print_array(int[] arr) {
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
