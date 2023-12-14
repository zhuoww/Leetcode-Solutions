/*
 * medium
 * time:O(m*n);space:O(m*n)
 */
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 其实就是求最长公共子序列，和1143题一样
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
