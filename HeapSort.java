package Heaps;

public class HeapSort {

    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] arr){
        int n = arr.length;
        // 1.convert to maxHeap
        for (int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        // 2. push large element at end

        for (int i=n-1; i>0; i--){
            //swap first and last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int i, int size){
        int lb = 2*i+1;
        int rb = 2*i+2;
        int max = i;

        if (lb < size && arr[lb] > arr[max]){
            max = lb;
        }

        if (rb < size && arr[rb] > arr[max]){
            max = rb;
        }

        if (i != max){
            //swap max and i
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, max, size);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9, 3, 6};
        print(arr);
        heapSort(arr);
        print(arr);

    }
}
