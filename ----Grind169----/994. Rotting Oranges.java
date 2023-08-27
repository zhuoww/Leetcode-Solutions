class Solution {
    public int orangesRotting(int[][] grid) {
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

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int time = 0;
        while (!que.isEmpty() && fresh != 0) {
            time++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cell = que.poll();
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        que.offer(new int[] { x, y });
                    }
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}
