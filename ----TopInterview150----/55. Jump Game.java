/*
 * medium
 */

//time:O(n);space:O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

// dp
// time:O(n^2);space:O(n)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len - 1] = true;

        for (int i = len - 2; i >= 0; i--) {
            int start = i + 1;
            int end = i + nums[i];

            for (int j = start; j <= end; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
