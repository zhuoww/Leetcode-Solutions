//dp
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
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

// greedy
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int l = 0;
        int r = 1;
        int max = 0;
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                max = Math.max(max, prices[r] - prices[l]);
                r++;
            } else {
                l = r;
                r++;
            }
        }
        return max;

    }
}
