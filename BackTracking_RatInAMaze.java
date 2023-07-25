public class BackTracking_RatInAMaze {

    public static void print_maze(int[][] sol){
        for (int i=0; i<sol.length; i++){
            for (int j=0; j< sol.length; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean is_Safe(int[][] maze, int x, int y){
        if (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==1) return true;
        else return false;
    }

    public static boolean maze_solver(int[][] maze){
        int n = maze.length;;
        int[][] sol = new int[n][n];
        if (maze_solve_until(maze, 0, 0, sol)==false){
            System.out.println("Solution does not exist");
        }
        System.out.println("Solution exist");
        print_maze(sol);
        return false;
    }

    public static boolean maze_solve_until(int[][] maze, int x, int y, int[][] sol){
        int n = maze.length;
        if (x==n-1 && y==n-1 && maze[x][y]==1){
            sol[x][y] = 1; // make it visited
            return true;
        }

        if (is_Safe(maze, x, y)){
            if (sol[x][y]==1) return false; // already visted

            sol[x][y] = 1;
            if (maze_solve_until(maze, x+1, y, sol)){ // down
                return true;
            }
            if (maze_solve_until(maze, x, y+1, sol)){ // right
                return true;
            }

            sol[x][y] = 0; // backtracking step
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };

        maze_solver(maze);
    }

}
