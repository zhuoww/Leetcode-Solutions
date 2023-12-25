/*
 * medium
 * time:O(n);space:O(1)
 */

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int curCover = 0;// 当前覆盖最远距离下标
        int nextCover = 0;// 下一步覆盖最远距离下标
        int res = 0;// 记录走的最大步数

        for (int i = 0; i < nums.length; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);// 更新下一步覆盖最远距离下标
            if (i == curCover) {// 遇到当前覆盖最远距离下标
                if (curCover < nums.length - 1) {
                    res++;// 需要走下一步
                    curCover = nextCover;// 更新当前覆盖最远距离下标
                    if (curCover >= nums.length - 1)
                        break;// 当前覆盖最远距到达集合终点，不用做res++操作了，直接结束
                } else {
                    break;
                }
            }
        }
        return res;
    }
}