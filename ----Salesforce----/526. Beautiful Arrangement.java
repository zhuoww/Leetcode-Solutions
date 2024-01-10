/*
 * medium
 * time:O(n!),The time complexity is determined by the number of permutations
 * space:O(n), where N is the input parameter n
 */

class Solution {
    private int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];// not use index 0
        backtracking(n, visited, 1);
        return count;
    }

    public void backtracking(int n, boolean[] visited, int index) {
        if (index > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (index % i == 0 || i % index == 0)) {
                visited[i] = true;
                backtracking(n, visited, index + 1);
                visited[i] = false;
            }
        }
    }
}