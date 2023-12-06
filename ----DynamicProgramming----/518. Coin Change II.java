/*
 * combination
 * 物品可加多次，求组合： 完全背包(背包正序），先物品再背包
 * 求多少种组合方式：初始化dp[0] = 1;
 * time: O(m * n); m is the amount, n is the length of the coins array
 * space: O(m)
 */

class Solution {
    public int change(int amount, int[] coins) {
        // combination
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
