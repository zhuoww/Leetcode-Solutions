package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//subsetsII: contain duplicates
//boolean[] used: mark used elements，避免树层取到duplicates
//startIndex: avoid getting the same elements
class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, 0);
        return res;
    }

    public void backtracking(int[] nums, boolean[] used, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length)
            return;

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)// Tree layer deduplication
                continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, i + 1);
            path.removeLast();
            used[i] = false;

        }
    }
}
