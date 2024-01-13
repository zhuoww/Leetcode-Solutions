/*
 * easy
 * time:O(n);space:O(1)
 */
//greedy
class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            res = Math.max(res, nums[i] - min);
        }
        return res == 0 ? -1 : res;
    }
}
