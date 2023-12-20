/*
 * easy
 * 
 */

//dp, time:O(n);space:O(n)
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;

        for (int i = 1; i <= n; i++) {
            res[i] = res[i / 2] + i % 2;
        }
        return res;
    }
}
