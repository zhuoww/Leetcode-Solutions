class Solution {
    // 主函数
    public void solveSudoku(char[][] board) {
        // 递归
        backtracking(board);

    }

    // 递归函数
    // 两个for循环，一个遍历行，一个遍历列
    private boolean backtracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 遇到原始数据，跳过
                if (board[i][j] != '.') {
                    continue;
                }

                // 遇到空格，判断数据合法否
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        boolean res = backtracking(board);
                        if (res == true) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都不合法
                return false;
            }
        }
        // 遍历完没有false就返回true
        return true;
    }

    // 验证此处放的数据是否合法的函数
    // 三个条件：1.判断同行是否重复；2.判断同列是否重复；3.判断9宫格是否重复
    public boolean isValid(char[][] board, int row, int col, char val) {
        // 1.行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        // 2.列
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }

        // 3.九宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;

    }
}
