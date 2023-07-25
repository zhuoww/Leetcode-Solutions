package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // BFS
        // time: O(m * n), space: O(m * n)
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    que.offer(new int[] { i, j });
                }
            }
        }
        if (que.size() == 0)
            return;

        int distance = 0;
        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        while (!que.isEmpty()) {
            distance++;
            int r = que.peek()[0];
            int c = que.peek()[1];
            que.poll();

            for (int[] direction : directions) {
                int x = r + direction[0];
                int y = c + direction[1];
                if (x < 0 ||
                        y < 0 ||
                        x >= rooms.length ||
                        y >= rooms[0].length ||
                        rooms[x][y] != Integer.MAX_VALUE)
                    continue;
                que.offer(new int[] { x, y });
                rooms[x][y] = rooms[r][c] + 1;
            }
        }
    }
}
