import java.util.Scanner;

public class Arrays_2D {

    public static void take_input(int[][] arr){
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void print(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void search(int[][] arr, int key){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                if (arr[i][j] == key) {
                    System.out.println("Element found at CELL : (" + i + "," + j + ")");
                }
            }
        }
    }

    public static void largest_smallest(int[][] arr){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                largest = Math.max(largest, arr[i][j]);
                smallest = Math.min(smallest, arr[i][j]);
            }
        }
        System.out.println("Largest element : " + largest + "\nSmallest element : " + smallest);
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of ROWS : ");
        int n = sc.nextInt();
        System.out.print("Enter no. of COLUMNS : ");
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        take_input(matrix);
        print(matrix);
        search(matrix, 4);
        largest_smallest(matrix);


    }

}
