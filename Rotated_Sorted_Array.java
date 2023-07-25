public class Rotated_Sorted_Array {

    public static int rotated_sorted_array(int arr[], int target){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low+high)/2;
            if (arr[mid] == target) return mid;

            // left part sorted : arr[low] <= arr[mid]
            if (arr[low] <= arr[mid]){
                // tracking is target is at left aur right
                if (arr[low] <= target && arr[mid] > target){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else { // right part is sorted : arr[low] > arr[mid]
                if (arr[mid] <= target && arr[high]> target){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(rotated_sorted_array(nums, 0));

    }
}
