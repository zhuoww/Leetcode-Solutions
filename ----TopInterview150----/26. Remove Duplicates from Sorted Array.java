/*
 * easy
 * time:O(n);space:O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];// slow++; nums[slow] = nums[fast];
            }
        }
        return slow + 1;

    }
}
