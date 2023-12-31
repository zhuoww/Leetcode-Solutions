//tips: stocks can only be bought and sold once
//tips: there are 2 states to choose from every day, holding stocks and not holding stocks
class Solution {
    public int maxProfit(int[] prices) {
        // dp
        if (prices == null || prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];// maximum profit when holding shares on the first day
        dp[0][1] = 0;// maximum profit without holding shares on the first day
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];

        // greedy
        // int l = 0;
        // int r = 1;
        // int maxPro = 0;

        // while(r < prices.length) {
        // if (prices[l] < prices[r]) {
        // maxPro = Math.max(maxPro, prices[r] - prices[l]);
        // r++;
        // }else {
        // l = r;
        // r++;
        // }
        // }
        // return maxPro;

    }
}
