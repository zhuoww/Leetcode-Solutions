/*
 * easy
 * time:O(n); space:O(n)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // map to store the value and index of the element
        HashMap<Integer, Integer> map = new HashMap<>();
        // res array to store the output
        int[] res = new int[2];
        // base case
        if (nums == null || nums.length == 0)
            return res;

        // loop through the nums array
        for (int i = 0; i < nums.length; i++) {
            // a variable to store the different between target and the current element
            int diff = target - nums[i];
            // check whether the diff is in the map
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
                break;// if find the valid index, break
            }
            // otherwise, add the value and index of the element to the map
            map.put(nums[i], i);
        }
        return res;
    }
}
