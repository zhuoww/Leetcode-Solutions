class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {// items
            for (int j = coins[i]; j <= amount; j++) {// bag
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
