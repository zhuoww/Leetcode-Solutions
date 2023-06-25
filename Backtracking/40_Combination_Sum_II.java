package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Combination Sum II: contains duplicates, solution set must not contain duplicate combination
//startIndex: avoid getting the same elements
//boolean[] used: mark used elements，避免树层取到duplicates
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, used, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, boolean[] used, int target, int sum, int startIndex) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false)
                continue;
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates, used, target, sum, i + 1);
            path.removeLast();
            sum -= candidates[i];
            used[i] = false;
        }
    }

}
