class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        int res = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] == 0) {
                    res = Math.max(res, dfs(matrix, dp, i, j, -1));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int[][] dp, int i, int j, int preValue) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= preValue)
            return 0;
        preValue = matrix[i][j];
        if (dp[i][j] != 0)
            return dp[i][j];
        int left = dfs(matrix, dp, i, j - 1, preValue);
        int right = dfs(matrix, dp, i, j + 1, preValue);
        int top = dfs(matrix, dp, i - 1, j, preValue);
        int bottom = dfs(matrix, dp, i + 1, j, preValue);

        dp[i][j] = 1 + Math.max(Math.max(left, right), Math.max(top, bottom));
        return dp[i][j];
    }
}
