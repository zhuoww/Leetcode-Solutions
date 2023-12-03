//easy
//time:O(n);space:O(1)

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        int[] p1 = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] p2 = points[i];
            int dx = Math.abs(p2[0] - p1[0]);
            int dy = Math.abs(p2[1] - p1[1]);

            count += Math.max(dx, dy);
            p1 = p2;
        }
        return count;
    }
}
