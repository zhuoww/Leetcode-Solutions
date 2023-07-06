class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
