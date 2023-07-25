public class Search_in_Matrix {

    public static boolean stair_Case_Search(int[][] arr, int key){ //O(n+m)
        int row = 0;
        int cols = arr[0].length-1;

        while (row < arr.length && cols >= 0){
            if (arr[row][cols] == key) {
                System.out.println("Key found at : " + row + "," + cols);
                return true;
            }

            if (arr[row][cols] > key){
                cols--;
            }else {
                row++;
            }

        }
        System.out.println("Key not Found!");
        return false;
    }

    public static void main(String[] args) {

        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 89, 98, 102},
                {123, 47, 34, 67}
        };

        stair_Case_Search(arr, 27); // expected : 1,2
    }

}
