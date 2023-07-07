class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (nums[r] == 0)
                k--;
            if (k < 0) {
                if (nums[l] == 0)
                    k++;
                l++;
            }
            r++;
        }
        return r - l;
    }
}
