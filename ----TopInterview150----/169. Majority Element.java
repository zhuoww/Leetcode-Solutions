/*
 * easy
 * time:O(n);space:O(1)
 */

class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int majority = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }

            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}

// time:O(nlogn);space:O(1)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}