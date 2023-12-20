package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        knight(board,0,0,n,res);
        System.out.println(res.size());
    }

    static void knight(boolean[][] board, int row, int col, int targets,ArrayList<List<String>> res){
        if(targets == 0){
            res.add(display(board));
            System.out.println();
            return;
        }

        if(row == board.length - 1 && col == board.length){
            return;
        }

        if(col == board.length){
            knight(board,row+1,0,targets,res);
            return;
        }

        if(isSafe(board,row,col)){
            board[row][col] = true;
            knight(board,row,col+1,targets-1,res);
            board[row][col] = false;
        }
        knight(board,row,col+1,targets,res);

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board,row - 1,col -2)){
            if(board[row - 1][col - 2]){
                return false;
            }
        }
        if(isValid(board,row - 1,col + 2)){
            if(board[row - 1][col + 2]){
                return false;
            }
        }
        if(isValid(board,row - 2,col - 1)){
            if(board[row - 2][col - 1]){
                return false;
            }
        }
        if(isValid(board,row - 2,col + 1)){
            if(board[row - 2][col + 1]){
                return false;
            }
        }

        return true;
    }

    private static boolean isValid(boolean[][] board,int row, int col) {
        if(row >= 0 && row < board.length && col >= 0 && col < board.length ){
            return  true;
        }
        return false;
    }

    private static List<String> display(boolean[][] board) {
        List<String> res = new LinkedList<String>();
        for(boolean[] row : board){
            String rowStr = "" ;
            for (boolean element : row){
                if(element) {
                    rowStr+="K";
                    System.out.print("K ");
                }else{
                    rowStr+=".";
                    System.out.print("X ");
                }
            }
            res.add(rowStr);
            System.out.println();
        }
        return res;
    }
}
