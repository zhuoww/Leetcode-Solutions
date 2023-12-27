/*
 * medium
 */

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        int l = 0;
        for (int r = 1; r < colors.length(); r++) {
            if (colors.charAt(l) == colors.charAt(r)) {
                res += Math.min(neededTime[l], neededTime[r]);
                if (neededTime[l] < neededTime[r]) {
                    l = r;
                }
            } else {
                l = r;
            }
        }
        return res;
    }
}