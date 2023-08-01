//dp
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}

// greedy
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (curSum <= 0)
                curSum = 0;
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
