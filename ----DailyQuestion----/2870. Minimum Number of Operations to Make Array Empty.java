/*
 * medium
 * time:O(n);space:O(n)
 */

class Solution {
    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == 1)
                return -1;
            count += val / 3;
            if (val % 3 != 0)
                count++;

        }
        return count;
    }
}
