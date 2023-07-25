public class Searching_Algos {

    public static int linear_search(int num[], int key){
        int index = 0;
        for (int i=0; i<num.length; i++){
            if (num[i] == key){
                index = i;
            }
        }

        return index;
    }

    public static int binary_search(int num[], int key){
        int start = 0;
        int end = num.length-1;

        while (start <= end){
            int mid = (start+end)/2;
            if (num[mid] == key){
                return mid;
            }

            if (num[mid] > key){ //left
                end = mid-1;
            }else { // right
                start = mid+1;
            }
        }
        return -1;
    }

    public static int bhawana_linear_search(int arr[], int key){
        int index = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == key){
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10, 12, 14 ,16};
        int linear_index = linear_search(arr, 10);
        System.out.println(linear_index);
        int binary_index = binary_search(arr, 12);
        System.out.println(binary_index);


        int arr2[] = {2, 4, 6, 8, 10, 12, 14};
        int answer = bhawana_linear_search(arr2, 8);
        System.out.println(answer);

        System.out.println(bhawana_bs(arr2,8));
    }

    public static int bhawana_bs(int arr[], int key){
        int start = 0;
        int end = arr.length-1;

        while (start<=end){
            int mid = (start+end)/2;
            if (arr[mid] == key){
                return mid;
            }

            if (arr[mid]>key){ // left
                end = mid-1;
            }else{
                // right
                start = mid+1;
            }
        }
        return  -1;
    }
}
