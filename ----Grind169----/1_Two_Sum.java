class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Tips: HashMap, temp = target - nums[i];
        // time: O(n)
        // space: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
