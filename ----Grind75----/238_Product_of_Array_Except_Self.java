class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0)
            return res;

        int l = 1;
        int r = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = l;
            l *= nums[i];
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= r;
            r *= nums[j];
        }
        return res;
    }
}
