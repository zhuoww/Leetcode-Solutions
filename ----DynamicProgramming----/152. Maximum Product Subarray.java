/*
 * medium
 * time:O(n);space:O(1)
 */

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int max = 1;
        int min = 1;
        int res = nums[0];

        for (int num : nums) {
            int temp = max;
            max = Math.max(num, Math.max(temp * num, min * num));
            min = Math.min(num, Math.min(temp * num, min * num));
            res = Math.max(res, max);
        }
        return res;
    }
}