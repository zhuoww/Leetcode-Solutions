/*
 * medium
 * time:O(n);space:O(1)
 */

class Solution {
    public int minimumOperations(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = 0;
        int leftSum = nums[l];
        int rightSum = nums[r];

        while (l < r) {
            if (leftSum == rightSum) {
                l++;
                r--;
                leftSum += nums[l];
                rightSum += nums[r];
            } else if (leftSum < rightSum) {
                l++;
                res++;
                leftSum += nums[l];
            } else {
                r--;
                res++;
                rightSum += nums[r];
            }
        }
        return res;
    }
}
