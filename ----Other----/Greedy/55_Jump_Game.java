package Greedy;

//tips: cover
class Solution {
    public boolean canJump(int[] nums) {
        // greedy
        if (nums.length == 1)
            return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1)
                return true;
        }
        return false;
    }
}
