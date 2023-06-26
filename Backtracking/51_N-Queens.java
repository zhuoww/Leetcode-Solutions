package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(chessboard, n, 0);
        return res;
    }

    public void backtracking(char[][] chessboard, int n, int row) {
        if (row == n) {
            res.add(item(chessboard));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(chessboard, n, row, i)) {
                chessboard[row][i] = 'Q';
                backtracking(chessboard, n, row + 1);
                chessboard[row][i] = '.';
            }
        }
    }

    public List<String> item(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(char[][] chessboard, int n, int row, int col) {
        // check column
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q')
                return false;
        }

        // check if there is a queen at a 45 degree diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q')
                return false;
        }

        // check if there is a queen at a 135 degree diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }

        return true;
    }

}
