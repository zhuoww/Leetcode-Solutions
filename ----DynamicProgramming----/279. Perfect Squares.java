/*
 * medium
 * time:O(n * √n)->for each iteration, the inner loop can run up to √n times;
 * space: O(n)
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                // 不需要判断if (dp[j - i * i] != max)，完全平方数这题一定可以用"1"来凑成任何一个n
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}