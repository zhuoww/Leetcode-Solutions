class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;

        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];// 持股
        dp[0][1] = 0;// 不持股

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][1];
    }
}
