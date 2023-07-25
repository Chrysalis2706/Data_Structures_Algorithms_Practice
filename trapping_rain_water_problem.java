public class trapping_rain_water_problem {

    public static int trapping_rain_water(int arr[]){

        int trapped_water = 0;

        // making left max array
        int left_max[] = new int[arr.length];
        left_max[0] = arr[0];
        for (int i=1; i<arr.length; i++){
            left_max[i] = Math.max(arr[i], left_max[i-1]);
        }

        // making right max array
        int n = arr.length;
        int right_max[] = new int[arr.length];
        right_max[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--){
            right_max[i] = Math.max(right_max[i+1], arr[i]);
        }

        // calculating water level = Minimum of left max and right max array
        // and trapped mater = water level - bar level(arr[i])
        for (int i=0; i<n; i++){
            int water_level = Math.min(left_max[i], right_max[i]);
            trapped_water += (water_level - arr[i]);
        }

       return trapped_water;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 0, 6, 3, 2, 5};
        int trapped_water = trapping_rain_water(arr);
        System.out.println(trapped_water);
    }
}
