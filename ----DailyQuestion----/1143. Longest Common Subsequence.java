/*
 * medium
 * time:O(m*n);space:O(m*n)
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] to store the longest common subsequence when at index i - 1 in text1
        // and at index j - 1 in text2----simplify the initialization of the dp array
        /*
         * 0 a b c d e i
         * 0 0 0 0 0 0 0
         * a 0
         * c 0
         * e 0
         * 
         * j
         * 
         * abcde ->text1
         * i
         * ace -> text2
         * j
         * 
         * compare text1.charAt(i - 1) == text2.charAt(j - 1) -> dp[i][j] = dp[i - 1][j
         * - 1] + 1
         * text1.charAt(i - 1) != text2.charAt(j - 1) -> dp[i][j] = Math.max(dp[i -
         * 1][j], dp[i][j - 1]);
         */

        // return dp[len1][len2]

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}