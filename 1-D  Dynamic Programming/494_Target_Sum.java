class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // dp
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (target < 0 && sum < -target)// if the target is too large, the sum will not be satisfied
            return 0;
        if ((target + sum) % 2 != 0)
            return 0;

        int left = (target + sum) / 2;// left + right = sum, left - right = target
        if (left < 0)
            left = -left;

        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];

    }
}
