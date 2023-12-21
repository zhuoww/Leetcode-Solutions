/*
 * medium
 * time:O(n) for initialization, O(log n) for each pick operation
 * space:O(n)
 */

class Solution {
    int[] sum;

    public Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        double target = Math.random() * (sum[sum.length - 1]);
        int l = 0;
        int r = sum.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target == sum[mid]) {
                return mid;
            } else if (target < sum[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
