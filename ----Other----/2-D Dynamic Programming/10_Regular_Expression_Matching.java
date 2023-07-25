
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];// store the results of subproblems
        return dfs(dp, s, p, 0, 0);
    }

    public boolean dfs(boolean[][] dp, String s, String p, int i, int j) {
        if (dp[i][j] != false)
            return dp[i][j];
        if (i >= s.length() && j >= p.length())// both strings have been fully matched
            return true;
        if (j >= p.length())
            return false;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            dp[i][j] = dfs(dp, s, p, i, j + 2) || (match && dfs(dp, s, p, i + 1, j));
        } else {
            dp[i][j] = match && dfs(dp, s, p, i + 1, j + 1);
        }
        return dp[i][j];
    }
}