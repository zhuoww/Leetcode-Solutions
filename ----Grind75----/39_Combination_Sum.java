import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> item = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int index) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(new ArrayList<>(item));
        }

        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {// if the sum is greater than
                                                                                          // target, there is no need to
                                                                                          // explore further candidates,
                                                                                          // saving unnecessary
                                                                                          // recursive calls
            sum += candidates[i];
            item.add(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            item.remove(item.size() - 1);
        }
    }

}