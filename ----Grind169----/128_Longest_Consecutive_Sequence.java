class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1))
                continue;
            int curNum = num;
            int curLen = 1;

            while (set.contains(curNum + 1)) {
                curNum++;
                curLen++;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}
