/*
 * medium
 * subarray子数组就是求连续子序列
 * dp[i]的定义：包括下标i之前的最大连续子序列和为dp[i]
 * time:O(n);space:O(n)
 * 注意最后的结果可不是dp[nums.size() - 1]！,找每一个i为终点的连续最大子序列,在递推公式的时候，可以直接选出最大的dp[i]
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}