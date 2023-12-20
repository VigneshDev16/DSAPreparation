package backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 6;
        boolean[][] board = new boolean[n][n];
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        System.out.println(queens(board,0,res));
        System.out.println(res);
    }
    static int queens(boolean[][] board, int row,ArrayList<List<String>> res){
        if(row == board.length){
            res.add(display(board));
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board,row+1,res);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical column
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //check left diagonal
        int minLeft = Math.min(row,col);
        for (int i = 1; i <= minLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        //check right diagonal
        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

//    private static List<String> constructBoard(boolean[][] board, ArrayList<List<String>> res) {
//        for ((boolean[] row : board)){
//
//        }
//    }

    private static List<String> display(boolean[][] board) {
        List<String> res = new LinkedList<String>();
        for(boolean[] row : board){
            String rowStr = "" ;
            for (boolean element : row){
                if(element) {
                    rowStr+="Q";
                    System.out.print("Q ");
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
