public class Practical_Practice {

    public static int partition(int[] arr, int si, int ei){
        int i = si-1;
        int pivot = arr[ei];


        // swap index with less than pivot

        for (int j=si; j<ei; j++){
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot and bring to desired index
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;

    }

    public static void quickSort(int[] arr, int si, int ei){
        if (si >= ei) return;

        int pindx = partition(arr,si,ei);
        quickSort(arr, si, pindx-1);
        quickSort(arr, pindx+1, ei);

    }

    public static void printArr(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 8, 6, 3};
        printArr(arr);
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
