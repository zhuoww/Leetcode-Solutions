class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet;
        HashSet<Character> colSet;

        for (int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];
                if (r != '.') {
                    if (rowSet.contains(r)) {
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }

                if (c != '.') {
                    if (colSet.contains(c)) {
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!check(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int rowIndex, int colIndex, char[][] board) {
        HashSet<Character> set = new HashSet<>();

        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = colIndex; j < colIndex + 3; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;

    }
}
