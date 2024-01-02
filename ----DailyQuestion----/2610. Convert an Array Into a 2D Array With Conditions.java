/*
 * medium
 */

//freq[]
//time:O(n);space:O(n)
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] freq = new int[nums.length + 1];
        for (int num : nums) {
            int row = freq[num];
            if (row == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(freq[num]).add(num);
            freq[num]++;
        }
        return res;
    }
}

// hashmap
// time:O(n*m);space:O(n+n*m)
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            count++;
        }

        while (count > 0) {
            List<Integer> path = new ArrayList<>();
            for (int key : map.keySet()) {
                if (map.get(key) > 0) {
                    path.add(key);
                    map.put(key, map.get(key) - 1);
                    count--;
                }
            }
            res.add(path);
        }
        return res;
    }
}