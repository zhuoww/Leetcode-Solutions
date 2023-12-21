/*
 * medium
 * time:O(nlogn);space:O(1)
 */

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int max = 0;
        for (int i = 1; i < points.length; i++) {
            int width = points[i][0] - points[i - 1][0];
            max = Math.max(max, width);
        }
        return max;
    }
}
