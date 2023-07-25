public class Sorting_BubbleSort {

    public static void bubble_sort(int arr[]){

        for (int turns = 0; turns<arr.length-1; turns++){ //for turns
            for (int j=0; j<arr.length-1-turns; j++){ // for swapping in turns
                if (arr[j] > arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

    public static void optimized_bubble_sort(int arr[]){

        for (int turns = 0; turns<arr.length-1; turns++){ //for turns
            boolean isSwapped = false;
            for (int j=0; j<arr.length-1-turns; j++){ // for swapping in turns
                if (arr[j] > arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    public static void print_array(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 2, 3};
        bubble_sort(arr);
        print_array(arr);

    }
}
