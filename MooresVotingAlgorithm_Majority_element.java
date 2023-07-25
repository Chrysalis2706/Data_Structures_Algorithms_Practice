public class MooresVotingAlgorithm_Majority_element {

    public static int majority_element(int[] arr, int size){
        int element = 0;
        int count = 0;

        for (int i=0; i<size; i++){
            // when count = 0 element ko arr[i] kardo
            if (count==0){
                element = arr[i];
            }
            // agr next element bhi same hai toh count++ kardo
            if (element==arr[i]) count++;
            else  count--;
        }

        // Counting the element frequency
        count = 0;
        for (int i=0; i<size; i++){
            if (arr[i]==element) count++;
        }

        if (count>(size/2)) return element;
        else return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int size = arr.length;
        System.out.println(majority_element(arr,size));
    }

}
