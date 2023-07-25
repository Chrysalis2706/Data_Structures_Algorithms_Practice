public class Nqueens {

    static int count = 0;

    public static void print_board(char[][] board){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean is_safe(char[][] board, int rows, int cols){
        // vertical up
        for (int i=rows-1; i>=0; i--){
            if (board[i][cols]=='Q') return false;
        }

        // left diagonal up
        for (int i=rows-1, j=cols-1; i>=0 && j>=0; i--, j--){
            if (board[i][j]=='Q') return false;
        }

        // right diagonal up
        for (int i=rows-1, j=cols+1; i>=0 && j<board.length; i--, j++){
            if (board[i][j]=='Q') return false;
        }

        return true;

    }

    public static void N_Queens(char[][] board, int rows){
        // base case
        if (rows == board.length) {
            System.out.println("_______BOARD_______");
            print_board(board);
            count++;
            return;
        }

        // recursion call
        for (int j=0; j<board.length; j++){
            if (is_safe(board, rows, j)){
                board[rows][j] = 'Q';
                N_Queens(board, rows+1);
                board[rows][j] = 'X'; // backtracking step
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                board[i][j] = 'X';
            }
        }
        N_Queens(board, 0);
        System.out.println("\n" + count);
    }
}
