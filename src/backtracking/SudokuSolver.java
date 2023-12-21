package backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        char a = '2';
        int b = Character.getNumericValue(a);
        System.out.println(a);

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }


    static boolean solve(int[][] board){

        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            //found an empty space break
            if(!emptyLeft){
                break;
            }
        }
        // no empty spaces , sudoku is solved
        if(emptyLeft){
            return true;
        }

        for (int num = 1; num <= 9 ; num++) {
            if(isSafe(board,row,col,num)){
                board[row][col] = num;
                if(solve(board)){
                    // answer found
                    return true;
                } else {
                    // wrong answer - backtrack
                    board[row][col]=0;
                }
            }

        }
        return false;
    }

    private static void display(int[][] board) {
        for(int[] row : board) {
            for(int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board,int row,int col,int num){

        //check row
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num){
                return false;
            }
        }

        //check col
        for(int[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }

        //check current matrix
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);
        for(int r=rowStart;r<sqrt;r++){
            for (int c = colStart; c < sqrt ; c++) {
                if(board[r][c] == num){
                    return false;
                }
            }
        }

        return true;

    }
}
