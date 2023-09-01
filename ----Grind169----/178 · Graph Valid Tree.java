public class Solution {
    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0 || n == 1)
            return true;
        if (edges.length == 0)
            return false;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        return dfs(edges[0][0], -1, visited, map) && visited.size() == n;
    }

    public boolean dfs(int cur, int pre, HashSet<Integer> visited, HashMap<Integer, List<Integer>> map) {
        if (visited.contains(cur))
            return false;
        visited.add(cur);

        for (int neighbor : map.get(cur)) {
            if (neighbor == pre)
                continue;
            if (!dfs(neighbor, cur, visited, map)) {
                return false;
            }
        }
        return true;
    }
}