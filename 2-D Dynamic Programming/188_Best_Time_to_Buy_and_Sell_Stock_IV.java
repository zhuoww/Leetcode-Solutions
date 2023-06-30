// tips: can buy at most k times and sell at most k times
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][2 * k + 1];
        dp[0][0] = 0;// no operation
        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];// maximum profit when holding shares on the first day
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];

    }
}