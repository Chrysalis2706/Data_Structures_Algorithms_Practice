public class Sorting_CountingSort {

    public static void counting_sort(int arr[]){

        //finding the largest value in the array
        int largest = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            largest = Math.max(arr[i], largest);
        }

        //making a counting array
        int[] count = new int[largest+1]; // as index from 0 to largest
        for (int i=0; i<count.length; i++){
            count[arr[i]]++;
        }

        //putting the values using count[]
        int j=0;
        for (int i=0; i<count.length; i++){
            while (count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

    public static void print_array(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 1, 3, 2, 4, 3, 7};
        counting_sort(arr);
        print_array(arr);
    }
}
