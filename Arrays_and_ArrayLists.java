import java.util.Arrays;

public class Arrays_and_ArrayLists {

    public static void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b; // Only supports call by value
    }

    public static void reverse_array(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
//            swap(arr[start], arr[end]);
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void array_pairs(int arr[]){
        for (int i=0; i<arr.length; i++){
            int first = arr[i];
            for (int j=i+1; j< arr.length; j++){
                System.out.print("(" + first + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void sub_arrays(int arr[]){
        for (int i=0; i<arr.length; i++){ // range starts
            for (int j=i; j< arr.length; j++){ // range ends
                for (int range=i; range<=j; range++){
                    System.out.print(arr[range] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void max_sub_array_bruteforce(int arr[]){
        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0;
        for (int i=0; i<arr.length; i++){ //range starts
            for (int j=i; j<arr.length; j++){ //range ends
                current_sum = 0;
                for (int range=i; range<j; range++){
                    current_sum = current_sum + arr[range];
                }
                System.out.println(current_sum);
                if (max_sum <= current_sum){
                    max_sum = current_sum;
                }
            }
        }

        System.out.println("Maximum sum = " + max_sum);

    }

    public static void max_sub_array_prefixsum(int arr[]){
        int max_sum = Integer.MIN_VALUE;
        int cur_sum = 0;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        for (int i=1; i< arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                cur_sum = 0;
                if (i<=0){
                    cur_sum = prefix[j];
                }else {
                    cur_sum = prefix[j] - prefix[i-1];
                }
            }
            if (cur_sum >= max_sum){
                max_sum = cur_sum;
            }
        }

        System.out.println("Maximum sum : " + max_sum);
    }

    public static void max_sub_array_kadanes(int arr[]){
        int max = Integer.MIN_VALUE;
        int cur_sum=0;
        int count = 0;
        for (int i=0; i<arr.length; i++){
            cur_sum = cur_sum + arr[i];
            if (cur_sum <= 0) {
                cur_sum = 0;
                count++;
            }
            max = Math.max(cur_sum, max);
        }

        if (count == arr.length) {
            System.out.println("Max sum : " + max_in_array(arr));
        }else {
            System.out.println("Max sum : " + max);
        }
    }

    public static int max_in_array(int arr[]){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int trap_water_problem(int arr[]){
        // left max height array
        int lm[] = new int[arr.length];
        lm[0] = arr[0];
        for (int i=1; i<arr.length; i++){
            lm[i] = Math.max(lm[i-1], arr[i]);
        }

        // right max height array
        int rm[] = new int[arr.length];
        rm[arr.length-1] = arr[arr.length-1];
        for (int i=arr.length-2; i>=0; i--){
            rm[i] = Math.max(rm[i+1], arr[i]);
        }

        // loop to calculate water level and trapped water
        int trapped_water = 0;
        for (int i=0; i<arr.length; i++){
            // water level = min of left most height and right most height
            int water_level = Math.min(lm[i], rm[i]);
            // trapped water = water level - height[i]
            trapped_water += water_level - arr[i];
        }
        return trapped_water;
    }

    public static void main(String[] args) {
        int array[] = {12, 34, 56, 78, 90, 120};
        int array2[] = {1, -2, 6, -1, 3};
        int array3[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        //1.
        reverse_array(array);
        System.out.println(Arrays.toString(array));

        //2.
        array_pairs(array);

        //3.
        sub_arrays(array);

        //4.
        max_sub_array_bruteforce(array2);

        //5.
        max_sub_array_prefixsum(array2);

        //6.
        max_sub_array_kadanes(array3);

        //7.
        int height[] = {3, 0, 2, 0, 4};
        int trapped_water = trap_water_problem(height);
        System.out.println(trapped_water);

    }
}
