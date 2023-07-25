
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited);
        return res;
    }

    public void backtracking(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true)
                continue;
            path.add(nums[i]);
            visited[i] = true;
            backtracking(nums, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}