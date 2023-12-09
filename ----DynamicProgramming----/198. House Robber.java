/*
 * medium
 * house robber入门级题目
 * 相邻房间不可偷
 * dp[i]: 考虑下标i以内的房间，最多可以偷的金额为dp[i]
 * 决定dp[i]的因素是第i房间偷还是不偷
 * 偷i：dp[i] = dp[i - 2] + nums[i]
 * 不偷i：dp[i] = dp[i - 1]
 * time:O(n);space:O(n)
 */

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
