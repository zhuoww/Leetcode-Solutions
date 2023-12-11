/*
 * medium
 * 和122题唯一的区别是，在收获利润时减去fee
 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0)
            return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];// 持有
        dp[0][1] = 0;// 不持有

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }
}
