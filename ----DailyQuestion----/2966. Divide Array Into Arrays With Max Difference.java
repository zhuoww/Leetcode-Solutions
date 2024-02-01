/*
 * medium
 * time: O(nlogn); space:O(n)
 */

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        if (nums == null || nums.length < 3 || nums.length % 3 != 0)
            return new int[][] {};

        int len = nums.length;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < len; i += 3) {
            if (i + 2 < len && nums[i + 2] - nums[i] <= k) {
                res.add(new int[] { nums[i], nums[i + 1], nums[i + 2] });
            } else {
                return new int[][] {};
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}