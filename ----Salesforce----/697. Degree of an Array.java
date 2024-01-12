/*
 * easy
 * time:O(n);space:O(n)
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();// count the frequency of every element
        HashMap<Integer, Integer> first = new HashMap<>();// store the element and it is index

        int degree = 0;
        int minLen = 0;

        for (int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i], i);// store the first position of the element
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);// count

            if (map.get(nums[i]) > degree) {
                // update degree
                degree = Math.max(degree, map.get(nums[i]));
                // update minLen
                minLen = i - first.get(nums[i]) + 1;
            } else if (map.get(nums[i]) == degree) {
                // update minLen
                minLen = Math.min(minLen, i - first.get(nums[i]) + 1);
            }
        }
        return minLen;
    }
}
