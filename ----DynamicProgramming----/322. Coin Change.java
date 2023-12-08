/*
 * medium
 * time: O(n * amount)，其中 n 为 coins 的长度
 * space: O(amount)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {// 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);// 若dp[j - coins[i]]==max, 那么此处会超出MAX_VALUE
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;

    }
}
