//dp
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;

    }
}

// greedy
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
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

// divide and conquer
class Solution {
    public int maxSubArray(int[] nums) {
        return findMaxSum(nums, 0, nums.length - 1);
    }

    public int findMaxSum(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];

        int mid = l + (r - l) / 2;
        int leftMax = findMaxSum(nums, l, mid);
        int rightMax = findMaxSum(nums, mid + 1, r);
        int crossMax = findMaxCrossSum(nums, l, mid, r);

        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }

    public int findMaxCrossSum(int[] nums, int l, int mid, int r) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid, sum = 0; i >= l; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        for (int i = mid + 1, sum = 0; i <= r; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}