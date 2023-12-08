/*
 * medium
 * time:O(n^3);space:O(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && set.contains(s.substring(i, j))) {// subtring是O(n)time complexity
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}