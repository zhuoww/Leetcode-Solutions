/*
 * medium
 * circle
 * 1.考虑包含首元素，不包含尾元素
 * 2.考虑包含尾元素，不包含首元素
 * time:O(n);space:O(n)
 */

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int len = nums.length;

        return Math.max(compare(nums, 0, len - 2), compare(nums, 1, len - 1));
    }

    public int compare(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
