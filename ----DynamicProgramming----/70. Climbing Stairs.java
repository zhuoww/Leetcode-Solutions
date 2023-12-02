//easy
//time:O(n);space:O(n)
class Solution {
    public int climbStairs(int n) {
        if (n < 2)
            return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}

// optimize space complexity
// time:O(n);space:O(1)
class Solution {
    public int climbStairs(int n) {
        if (n < 2)
            return n;

        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
