class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
