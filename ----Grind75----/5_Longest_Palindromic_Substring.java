class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLen = 1;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);

    }
}
