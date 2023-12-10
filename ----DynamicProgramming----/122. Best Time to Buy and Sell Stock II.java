/*
 * medium
 * 与买卖股票I唯一不同的是推导dp[i][0]的时候，第i天买入股票的情况: 
 * 本题，因为一只股票可以买卖多次，所以当第i天买入股票的时候，所持有的现金可能有之前买卖过的利润
 * dp[i][0],如果是第i天买入股票，所得现金就是昨天不持有股票的所得现金 减去 今天的股票价格: dp[i - 1][1] - prices[i]
 */

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
