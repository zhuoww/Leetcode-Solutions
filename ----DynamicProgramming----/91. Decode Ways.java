/*
 * medium
 * 
 */

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;// the string cannot be decoded

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            // Single-digit decoding
            // If the current character is not '0', it means that it can be decoded as a
            // single-digit number
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two-digit decoding
            // If the last two characters form a valid two-digit number (between 10 and 26
            // inclusive)
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
