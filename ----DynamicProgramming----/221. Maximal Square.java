/*
 * medium
 * time:O(m*n);space:O(m*n)
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int res = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {// 若单前格是1，则开始check
                    // 由正上方，左侧和斜上角的三个数取一个最小值再加1得出此格的最大square
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    if (dp[i][j] > res)
                        res = dp[i][j];
                }
            }
        }
        return res * res;
    }
}
