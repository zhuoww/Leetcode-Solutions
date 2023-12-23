/*
 * medium
 * time:O(n);space:O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            int count = 1;
            while (fast + 1 < nums.length && nums[fast] == nums[fast + 1]) {
                fast++;
                count++;
            }

            int range = Math.min(2, count);
            for (int i = 0; i < range; i++) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
