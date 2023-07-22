class Solution {
    public int maxCoins(int[] nums) {
        // time: O(n^3)
        // space: O(n^2)
        int len = nums.length;
        int[][] dp = new int[len][len];// store the maximum number of coins that can be obtained by bursting balloons
                                       // between different indices
        return burst(nums, dp, 0, len - 1);
    }

    public int burst(int[] nums, int[][] dp, int left, int right) {
        if (left > right)
            return 0;
        // checks if the result for the current range (left to right) has already been
        // computed and stored in the dp array
        if (dp[left][right] != 0) {// avoid redundant computations
            return dp[left][right];
        }

        for (int i = left; i <= right; i++) {
            int coins = nums[i];
            if (left - 1 >= 0)
                coins *= nums[left - 1];
            if (right < nums.length - 1)
                coins *= nums[right + 1];
            coins += burst(nums, dp, left, i - 1) + burst(nums, dp, i + 1, right);// left subrange: (left, i - 1); right
                                                                                  // subrange: (i + 1, right)
            dp[left][right] = Math.max(dp[left][right], coins);// updates the maximum number of coins for the current
                                                               // range (dp[left][right]
        }

        return dp[left][right];
    }
}
