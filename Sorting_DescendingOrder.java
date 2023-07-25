public class Sorting_DescendingOrder {

    public static void print_array(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // 1. Bubble sort
    public static void bubble_sort(int[] arr){

        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-1-i; j++){
                if (arr[j+1] > arr[j]){ //descinding order
                    //swap arr[j] and arr[j+1]
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }


    //2. Selection sort
    public static void selection_sort(int[] arr){

        for (int i=0; i< arr.length-1; i++){
            int minpos = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[j] > arr[minpos]) minpos = j;  //descending order
            }
            // swapping arr[minpos] and arr[i]
            int t = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = t;
        }

    }

    // 3. Insertion sort
    public static void insertion_sort(int[] arr){

        for (int i=0; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] < curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1] = curr;
        }

    }

    // 4. Counting sort
    public static void counting_sort(int[] arr){

        // 1. finding range
        int largest = Integer.MIN_VALUE;
        for (int i=0; i< arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        // 2. making counting array
        int[] count = new int[largest+1];
        for (int i=0; i<count.length; i++){
            count[arr[i]]++;
        }

        // 3. putting elements in the array according to frequency
        int j=0;
        for (int i=0; i<count.length; i++){  // opposite loop from n-1 to 0 for descending order
            while (count[i] > 0){
                arr[j] = i; // index is the actual number in the main array
                count[i]--;
                j++;
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 2, 4,};
        bubble_sort(arr);
        print_array(arr);

        System.out.println();

        int[] arr2 = {1, 5, 3, 2, 4,};
        selection_sort(arr2);
        print_array(arr2);

        System.out.println();

        int[] arr3 = {1, 5, 3, 2, 4,};
        insertion_sort(arr3);
        print_array(arr3);

        System.out.println();
        int[] arr4 = {1, 4, 1, 3, 2, 4, 1, 7};
        counting_sort(arr4);
        print_array(arr4);



    }

}
