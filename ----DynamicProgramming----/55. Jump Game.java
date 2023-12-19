/*
 * medium
 * 
 */
//dp--time:O(n^2);space:O(n)
class Solution {
    public boolean canJump(int[] nums) {
        // dp is used to store whether it is possible to reach the last index from each
        // position.
        boolean[] dp = new boolean[nums.length];

        dp[nums.length - 1] = true;// it is always possible to reach the last index from the last position

        for (int i = nums.length - 2; i >= 0; i--) {
            // calculates the range of indices that can be reached from the current position
            int start = i + 1;
            int end = i + nums[i];

            // checks if any of them is marked as reachable (true)
            // If so, it sets dp[i] to true because the current position can reach a
            // position that can reach the end
            for (int j = start; j <= end; j++) {
                if (dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}

// greedy---time:O(n);space:O(1)
class Solution {
    public boolean canJump(int[] nums) {
        // greedy
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
