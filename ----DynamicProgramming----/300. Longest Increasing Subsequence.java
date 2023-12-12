/*
 * medium
 * time:O(n^2); space:O(n)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}