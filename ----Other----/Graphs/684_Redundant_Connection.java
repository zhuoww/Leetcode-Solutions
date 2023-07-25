package Graphs;

class Solution {
    int n;
    int[] parent;

    public Solution() {
        n = 1001;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int u) {// finds the parent node of a given node u
        if (u == parent[u]) {
            return u;
        } else {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    private boolean same(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;// compares their root parents
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return;
        parent[v] = u;// their parents are different, merge
    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (same(edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return null;// no redundant edge is found
    }

}