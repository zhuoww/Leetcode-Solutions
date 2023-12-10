/*
 * easy
 * dp[i][0] 表示第i天持有股票所得最多现金; dp[i][1] 表示第i天不持有股票所得最多现金
 * dp[i][0] = max(dp[i - 1][0], -prices[i]); dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
 * dp[0][0] -= prices[0]; dp[0][1] = 0;
 * time: O(n); space: O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];// 持有
        dp[0][1] = 0;// 不持有

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
