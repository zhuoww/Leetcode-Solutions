/*
 * permutation
 * 物品可加多次，求排列： 完全背包(背包正序），先背包再物品
 * 求多少种组合方式：初始化dp[0] = 1;
 * time: O(m * n); m is the target, n is the length of the nums array
 * space: O(m)
 */

class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 求排列：Note that different sequences are counted as different combinations.
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
