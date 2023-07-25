public class DevideAndConquer_QuickSort {

    public static void quickSort(int[] arr, int si, int ei){

        // Base case
        if (si>=ei) return;

        int pindx = partition(arr, si, ei);
        quickSort(arr, si, pindx-1);
        quickSort(arr, pindx+1, ei);
    }

    public static int partition(int[] arr, int si, int ei){
        int i = si-1; // i will take care of the place to for smaller elements
        int pivot = arr[ei];

        // loop to change the place of elements smaller than pivot
        for (int j=si; j<ei; j++){
            if (arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // swap with pivot to put it in right place
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }


    public static void printArray(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 8, 2, 5};
        System.out.println("Input array : ");
        printArray(arr);


        quickSort(arr, 0, arr.length-1);

        System.out.println("\nOutput array : ");
        printArray(arr);
    }

}
