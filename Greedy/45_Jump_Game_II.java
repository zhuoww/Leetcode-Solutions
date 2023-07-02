package Greedy;

class Solution {
    public int jump(int[] nums) {
        // greedy
        if (nums.length == 1)
            return 0;
        int res = 0;
        int cur = 0;
        int next = 0;

        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == cur) {
                if (cur < nums.length - 1) {
                    res++;
                    cur = next;
                    if (next >= nums.length - 1)
                        break;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}