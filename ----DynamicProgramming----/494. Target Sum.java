/*
 * medium
 * time: O(n * m), n is the number of positive numbers, m is the size of the bag
 * spaceL O(m)
 * 
 * 求有多少种方法： dp[j] += dp[j - nums[i]];
 */

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum)
            return 0;
        if ((sum + target) % 2 != 0)
            return 0;

        int left = (sum + target) / 2;
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
