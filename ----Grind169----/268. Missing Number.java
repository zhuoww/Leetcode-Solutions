/*
 * easy
 * time:O(n);space:O(1)
 */

//bit manipulation
class Solution {
    public int missingNumber(int[] nums) {
        // XOR
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }
}

// sum
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += (i - nums[i]);
        }
        return res;
    }
}
