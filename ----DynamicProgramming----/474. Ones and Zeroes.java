/*
 * medium
 * time:O(k*m*n)，k 为strs的长度; space:O(m*n)
 */

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
        // 字符串本身的个数相当于物品的价值（value[i]）
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        // items
        for (String str : strs) {
            int zeroes = 0;
            int ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            // bag,两个维度的背包
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
