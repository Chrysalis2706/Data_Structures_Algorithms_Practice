public class BackTracking_NQueensProblem {

    static int count = 0;

    public static void print_board(char[][] board){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean is_safe(char[][] board, int row, int col){
        // vertical up
        for (int i=row-1; i>=0; i--){
            if (board[i][col] == 'Q') return false;
        }

        // left diagonal up
        for (int i=row-1, j = col-1; i>=0 && j>=0; i--,j--){
            if (board[i][j]=='Q') return false;
        }

        // right diagonal up
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if (board[i][j]=='Q') return false;
        }

        return true;
    }

    public static void N_Queens_all_sols(char[][] board, int row){

        // base case
        if (row==board.length) {
            System.out.println("__________BOARD___________");
            print_board(board);
            count++;
            return;
        }

        // recursion call
        for (int j=0; j<board.length; j++){ // loop for cols bcz only one queen in one row
            if (is_safe(board, row, j)){
                board[row][j] = 'Q';
                N_Queens_all_sols(board, row+1);
                board[row][j] = 'X'; // backtracking step
            }
        }
    }

    public static boolean N_Queens_only_one(char[][] board, int row){

        // base case
        if (row==board.length) {
//            System.out.println("__________BOARD___________");
//            print_board(board);
            return true;
        }

        // recursion call
        for (int j=0; j<board.length; j++){ // loop for cols bcz only one queen in one row
            if (is_safe(board, row, j)){
                board[row][j] = 'Q';
                if (N_Queens_only_one(board, row+1)){
                    return true;
                }
                board[row][j] = 'X'; // backtracking step
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = 'X';
            }
        }

//        // Print all the solutions
//        N_Queens_all_sols(board, 0);
//
//
//        // Count solutions
//        System.out.println("\nTotal ways to solve : " + count);

        // Print only one solution if exists
        if (N_Queens_only_one(board,0)){
            System.out.println("Solution exists");
            N_Queens_only_one(board, 0);
            print_board(board);
        }else {
            System.out.println("Solution do not exist");
        }

    }
}
