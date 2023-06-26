package Graphs;

class Solution {
    // time: O(m * n)
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;// mark the visited cells to avoid revisiting them

        return (1 + dfs(grid, row - 1, col) +
                dfs(grid, row + 1, col) +
                dfs(grid, row, col - 1) +
                dfs(grid, row, col + 1));
    }
}