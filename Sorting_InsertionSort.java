public class Sorting_InsertionSort {

    public static void insertion_sort(int[] arr){

        for (int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            // where to put element
            while (prev >=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1] = curr;
        }

    }

    public static void print_array(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 1, 2};
        insertion_sort(arr);
        print_array(arr);
    }
}
