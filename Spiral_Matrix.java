public class Spiral_Matrix {

    public static void spiral_matrix(int[][] arr){
        //Rows
        int row = arr.length;
        int left = 0;
        int right = row-1;
        //Columns
        int cols = arr[0].length;
        int top = 0;
        int bottom = cols-1;

        while (top<=bottom && left<=right){

            //top
            for (int i=left; i<=right; i++){
                System.out.print(arr[top][i] + " ");
            }
            top++;

            //right
            for (int i=top; i<=bottom; i++){
                System.out.print(arr[i][right] + " ");
            }
            right--;

            if (top<=bottom){
                for (int i=right; i>=left; i--){
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            if (left<=right){
                for (int i=bottom; i>=top; i--){
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }

        }

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        spiral_matrix(arr);
    }

}


