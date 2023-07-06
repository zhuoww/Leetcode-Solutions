class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // time: O(n)
        // space: O(1)
        if (image[sr][sc] == color)
            return image;
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int origColor, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != origColor) {
            return;
        }
        image[sr][sc] = color;
        fill(image, sr + 1, sc, origColor, color);
        fill(image, sr - 1, sc, origColor, color);
        fill(image, sr, sc + 1, origColor, color);
        fill(image, sr, sc - 1, origColor, color);
    }
}
