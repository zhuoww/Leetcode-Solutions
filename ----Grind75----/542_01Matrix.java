import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int count = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cell = que.poll();
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length)
                        continue;
                    if (mat[x][y] == -1) {
                        mat[x][y] = count;
                        que.offer(new int[] { x, y });
                    }
                }
            }
        }
        return mat;
    }
}
