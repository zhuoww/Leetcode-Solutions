package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        // BFS
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> que = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int count = 0;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!que.isEmpty() && fresh != 0) {
            count++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int r = que.peek()[0];
                int c = que.peek()[1];
                que.poll();

                for (int[] direction : directions) {
                    int x = r + direction[0];
                    int y = c + direction[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        que.offer(new int[] { x, y });
                        fresh--;
                    }
                }

            }

        }
        return fresh == 0 ? count : -1;

    }
}