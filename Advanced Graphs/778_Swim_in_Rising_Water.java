import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int len = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        boolean[][] visited = new boolean[len][len];
        visited[0][0] = true;
        int res = 0;

        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            res = Math.max(res, cur[0]);
            if (cur[1] == len - 1 && cur[2] == len - 1)
                break;
            for (int[] direction : directions) {
                int x = cur[1] + direction[0];
                int y = cur[2] + direction[1];
                if (x < 0 || y < 0 || x == len || y == len || visited[x][y] == true)
                    continue;
                minHeap.offer(new int[] { grid[x][y], x, y });
                visited[x][y] = true;
            }
        }
        return res;
    }
}
