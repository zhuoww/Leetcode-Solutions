//二维boolean数组
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[len + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {// 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {// 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][target];

    }
}

// 一维数组
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
