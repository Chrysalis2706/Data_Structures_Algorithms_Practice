public class BackTracking_SudokuSolver {

    public static void print_sudoku(int[][] sudoku){
        int rows = sudoku.length;
        int cols = sudoku[0].length;

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean is_Safe(int[][] sudoku, int rows, int cols, int digit){
        // columns
        for (int i=0; i<9; i++){
            if (sudoku[i][cols]==digit) return false;
        }// rows
        for (int j=0; j<9; j++){
            if (sudoku[rows][j]==digit) return false;
        }
        // mini grid
        int sr = (rows/3)*3;
        int sc = (cols/3)*3;
        for (int i=sr; i<sr+3; i++){
            for (int j=sc; j<sc+3; j++){
                if (sudoku[i][j]==digit) return false;
            }
        }
        return true;
    }

    public static boolean sudoku_solver(int[][] sudoku, int rows, int cols){
        // base case
        if (rows==9 && cols ==0) return true;


        // specifying next row and col
        int next_row = rows, next_col = cols+1;
        if (cols+1==9) {
            next_col = 0;
            next_row = rows+1;
        }

        if (sudoku[rows][cols]!=0) {
            sudoku_solver(sudoku, next_row, next_col);
        }

        for (int digit = 1; digit<=9; digit++){
            if (is_Safe(sudoku, rows, cols, digit)){
                sudoku[rows][cols] = digit;
                if (sudoku_solver(sudoku, next_row, next_col)){
                    return true;
                }
                sudoku[rows][cols] = 0; // back tracking step
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                {8, 4, 9, 0, 0, 3, 5, 7, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 9, 0, 0, 8, 3},
                {0, 0, 0, 9, 4, 6, 7, 0, 0},
                {0, 8, 0, 0, 5, 0, 0, 4, 0},
                {0, 0, 6, 8, 7, 2, 0, 0, 0},
                {5, 7, 0, 0, 1, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 2, 1, 7, 0, 0, 8, 6, 5}
                 };

        int rows = sudoku.length;
        int cols = sudoku[0].length;

        if (sudoku_solver(sudoku, 0, 0)){
            System.out.println("Solutions possible");
            print_sudoku(sudoku);
        }else {
            System.out.println("Solution not possible");
        }
    }
}
