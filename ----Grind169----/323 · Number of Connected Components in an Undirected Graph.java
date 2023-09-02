//dfs
public class Solution {
    /**
     * @param n:     the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(edges, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] edges, boolean[] visited, int cur) {
        if (visited[cur])
            return;
        visited[cur] = true;

        for (int[] edge : edges) {
            if (edge[0] == cur && !visited[edge[1]]) {
                dfs(edges, visited, edge[1]);
            }

            if (edge[1] == cur && !visited[edge[0]]) {
                dfs(edges, visited, edge[0]);
            }
        }
    }
}

// bfs
public class Solution {
    /**
     * @param n:     the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                que.offer(i);

                while (!que.isEmpty()) {
                    int cur = que.poll();
                    visited[cur] = true;
                    for (int[] edge : edges) {
                        if (edge[0] == cur && !visited[edge[1]]) {
                            que.offer(edge[1]);
                        }
                        if (edge[1] == cur && !visited[edge[0]]) {
                            que.offer(edge[0]);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}

// unionFind
public class Solution {
    /**
     * @param n:     the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int count = n;
        for (int[] edge : edges) {
            int a = find(edge[0], parent);
            int b = find(edge[1], parent);

            if (a == b) {
                continue;
            } else {
                if (rank[b] > rank[a]) {
                    parent[a] = b;
                    rank[b] += rank[a];
                } else {
                    parent[b] = a;
                    rank[a] += rank[b];
                }
                count--;
            }
        }
        return count;
    }

    public int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}