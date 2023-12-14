/*
 * easy
 * time:O(m*n);space:O(m*n)
 * 与1143最长公共子序列那题类似
 * if (s[i - 1] == t[j - 1]),t中找到了一个字符在s中也出现了,dp[i][j] = dp[i - 1][j - 1] + 1
 * if (s[i - 1] != t[j - 1]),相当于t要删除元素，继续匹配,此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，
 * 那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，即：dp[i][j] = dp[i][j - 1];
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;

        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];// 与最长公共子序列不同之处
                }
            }
        }
        return dp[len1][len2] == len1;// 与最长公共子序列不同之处

    }
}
