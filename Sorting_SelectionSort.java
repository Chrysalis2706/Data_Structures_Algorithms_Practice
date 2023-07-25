public class Sorting_SelectionSort {

    public static void selection_sort(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            int minpos = i;
            for (int j=i+1; j<arr.length ; j++){
                if (arr[minpos] > arr[j]) minpos = j;
            }
            //swapping arr[i] & arr[minpos]
             int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void print_array(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 1, 3, 2};
        selection_sort(array);
        print_array(array);
    }
}
