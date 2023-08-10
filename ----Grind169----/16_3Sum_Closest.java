class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }

                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
