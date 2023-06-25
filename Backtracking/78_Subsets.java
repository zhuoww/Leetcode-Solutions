package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // time; O(2^N)--N is the length of the input array nums, for each
    // element in the input array, we have two choices: include or exclude
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));

        if (startIndex >= nums.length)
            return;

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
