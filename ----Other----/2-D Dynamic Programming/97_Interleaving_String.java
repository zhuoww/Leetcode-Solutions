class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // time: O(m * n), m is the length of string s1 and n is the length of string s2
        // space: O(m * n)
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];// each element in the dp array indicates whether
                                                                       // the corresponding substring can be formed or
                                                                       // not
        dp[s1.length()][s2.length()] = true;// empty substrings of s1 and s2 can be interleaved to form an empty string
                                            // s3

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // ensure that the next substring s3.substring(i + j + 1) can be formed using
                // the remaining characters of s1 and s2 by checking dp[i + 1][j]
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}
