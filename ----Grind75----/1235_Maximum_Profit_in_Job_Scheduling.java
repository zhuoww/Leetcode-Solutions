import java.util.Arrays;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] dp = new int[len][4];
        for (int i = 0; i < len; i++) {
            dp[i] = new int[] { startTime[i], endTime[i], profit[i], profit[i] };
        }
        Arrays.sort(dp, (a, b) -> a[1] - b[1]);

        for (int i = 1; i < len; i++) {
            dp[i][3] = Math.max(dp[i][2], dp[i - 1][3]);
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j][1] <= dp[i][0]) {
                    dp[i][3] = Math.max(dp[i][3], dp[j][3] + dp[i][2]);
                    break;
                }
            }
        }
        return dp[len - 1][3];
    }
}
