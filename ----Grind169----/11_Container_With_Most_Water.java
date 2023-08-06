class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int w = r - l;
            maxArea = Math.max(maxArea, h * w);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
