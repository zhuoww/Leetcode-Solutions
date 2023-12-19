/*
 * easy
 * time:O(m*n);space:O(m*n)
 */

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;

        int[][] res = new int[row][col];
        int[] rowOffset = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colOffset = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = img[i][j];
                int count = 1;
                for (int k = 0; k < 8; k++) {
                    int x = i + rowOffset[k];
                    int y = j + colOffset[k];

                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        sum += img[x][y];
                        count++;
                    }
                    res[i][j] = sum / count;
                }
            }
        }
        return res;
    }
}
