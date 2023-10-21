class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0)
            return res;
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtracking(board, n, 0);
        return res;
    }

    public void backtracking(char[][] board, int n, int row) {
        if (row == n) {
            res.add(item(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(board, n, row, i)) {
                board[row][i] = 'Q';
                backtracking(board, n, row + 1);
                board[row][i] = '.';
            }
        }
    }

    public List<String> item(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(char[][] board, int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}