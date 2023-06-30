// tips: stocks can only be bought and sold twice
// there are 4 possible states per day
class Solution {
    public int maxProfit(int[] prices) {
        // dp
        if (prices == null || prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);// buying stock for the first time
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);// selling stock for the first time
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);// buying stock for the second time
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);// selling stock for the second time
        }
        return dp[prices.length - 1][3];

    }
}