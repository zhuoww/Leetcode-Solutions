//backtracking
class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    public void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true)
                continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }

    }
}
