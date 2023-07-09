import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] res = new int[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            res[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(res);
        long minScore = 0;
        long maxScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minScore += res[i];
            maxScore += res[res.length - i - 1];
        }

        return maxScore - minScore;
    }
}
