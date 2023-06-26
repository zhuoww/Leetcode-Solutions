package Graphs;

class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        // capture unsurrounded regions - top and bottom row
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[row - 1][i] == 'O')
                dfs(board, row - 1, i);
        }

        // capture unsurrounded regions - left and right column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][col - 1] == 'O')
                dfs(board, i, col - 1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] != 'O')
            return;
        board[row][col] = 'T';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}