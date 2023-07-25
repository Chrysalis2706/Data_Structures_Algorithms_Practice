import java.util.Arrays;

public class DevideAndConquer_MergeSort {

    public static void mergeSort(int[] arr, int si, int ei){
        // base case
        if (si>=ei) return;
        // find mid
        int mid = si + (ei-si)/2;
        // devide
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid+1, ei); // right part
        // conquer
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei-si+1];
        int i = si; //left part iterator
        int j = mid+1; // right part iterator
        int k = 0; // temp arr iterator

        //left aur right mai sai temp mai rakho
        while (i<=mid && j<=ei){
            if (arr[i]<arr[j]) {
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // left elements in left part
        while (i<= mid){
            temp[k++] = arr[i++];
        }

        // left elements in right part
        while (j<=ei){
            temp[k++] = arr[j++];
        }

        // copy temp array to original array
        for (k=0,i=si; k< temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void printArray(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr= { 6, 3, 9, 5, 2, 8};
        System.out.println("Input array : ");
        printArray(arr);


        mergeSort(arr, 0, arr.length-1);

        System.out.println("\nOutput array : ");
        printArray(arr);
    }

}
