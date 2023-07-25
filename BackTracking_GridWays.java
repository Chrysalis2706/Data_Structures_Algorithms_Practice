public class BackTracking_GridWays {

    public static int fact(int n){
        int ans  = 1;

        for (int i=n; i>0; i--){
            ans = ans * i;
        }

        return ans;
    }

    // TC : O(2^(n+m))
    public static int grid_ways(int i, int j, int row, int col){
        // base cases
        if (i==row-1 && j==col-1) return 1;
        else if (i==row || j==col ) return 0;

        // recursion call
        int right = grid_ways(i, j+1, row, col);
        int down = grid_ways(i+1, j, row, col);

        return right+down;
    }


    // TC : O(n+m)
    public static int grid_ways_optimized(int row, int col){
        int ways = 0;

        int num = fact((row-1) + (col-1));
        int den = fact(row-1) * fact(col-1);
        ways = num/den;

        return ways;
    }

    public static void main(String[] args) {
        int row = 4, col = 4;
        System.out.println(grid_ways(0,0,row,col));
        System.out.println(grid_ways_optimized(row,col));
    }

}
