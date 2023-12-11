/*
 * medium
 * 1.持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
 * 不持有股票状态，这里就有两种卖出股票状态
 * 2.保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
 * 3.今天卖出股票
 * 4.今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];// holding stock
        dp[0][1] = 0;// maintain the state after selling the stock
        dp[0][2] = 0;// selling stock
        dp[0][3] = 0;// cooldown

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }
}
