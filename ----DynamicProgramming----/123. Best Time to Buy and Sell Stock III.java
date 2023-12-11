/*
 * hard
 * 一天一共就有五个状态，
 * 1.没有操作（可以不设置这个状态）
 * 2.第一次持有股票
 * 3.第一次不持有股票
 * 4.第二次持有股票
 * 5.第二次不持有股票
 * dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金。
 * 例如 dp[i][1] ，并不是说 第i天一定买入股票，有可能 第 i-1天 就买入了，那么 dp[i][1] 延续买入股票的这个状态
 * time:O(n);space:O(n*5)
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];// 第一次持有
        dp[0][2] = 0; // 第一次不持有
        dp[0][3] = -prices[0];// 第二次持有
        dp[0][4] = 0; // 第二次不持有

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
