/*
 * greedy
 * time:O(n);space:O(1)
 */

class Solution {
    public int maxProduct(int[] nums) {
        int leftMax = nums[0];
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, (leftMax - 1) * (nums[i] - 1));
            leftMax = Math.max(leftMax, nums[i]);
        }
        return res;
    }
}