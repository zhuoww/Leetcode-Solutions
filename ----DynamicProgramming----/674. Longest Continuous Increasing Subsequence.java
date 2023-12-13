/*
 * easy
 * dp[i]：以下标i为结尾的连续递增的子序列长度为dp[i]
 * 以下标i为结尾的连续递增的子序列长度最少也应该是1，即就是nums[i]这一个元素
 * time:O(n);space:O(n)
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int res = 0;

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}