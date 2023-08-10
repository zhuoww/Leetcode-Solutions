class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;

        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[index--] = nums[l] * nums[l];
                l++;
            } else {
                res[index--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}
