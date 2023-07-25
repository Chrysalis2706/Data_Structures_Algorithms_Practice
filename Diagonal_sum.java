public class Diagonal_sum {

    //        1. Brute force O(n^2)
    public static int diagonal_sum(int[][] arr){

        int r = arr.length;
        int c = arr[0].length;
        int sum = 0;

        if (r!=c) {
            return -1;
        }else {
            int n = r;
            for (int i=0; i<n ; i++){
                for (int j=0; j<n; j++){
                    if (i==j){
                        sum += arr[i][i];
                    }
                    if (i+j == (n-1)){
                        sum += arr[i][j];
                    }
                }
            }
        }

        return sum;
    }


    // 2. Optimized : O(n)
    public static int diagonal_sum_optimized(int[][] arr){
        int sum = 0;
        int r = arr.length;
        int c = arr[0].length;

        if (r!=c){
            return -1;
        }else {
            int n = arr.length;
            for (int i=0; i<n; i++){

                // diagonal left to right : i==j
                sum += arr[i][i];

                // diagonal right to left : j = n-1-i
                sum += arr[i][n-1-i];

            }
        }

        return sum;
    }


    public static void main(String[] args) {

        int[][] arr = {
                {1,  2,   3,  4},
                {5,  6,   7,  8},
                {9,  10, 11,  12},
                {13, 14, 15, 16}
        };

        int sum = diagonal_sum(arr);
        System.out.println(sum);
        System.out.println(diagonal_sum_optimized(arr));


    }
}
