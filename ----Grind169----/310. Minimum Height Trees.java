class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0)
            return res;
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                que.offer(i);
            }
        }

        while (n > 2) {
            int size = que.size();
            n -= size;
            while (size > 0) {
                int cur = que.poll();
                for (int i : adj.get(cur)) {
                    degree[i]--;
                    if (degree[i] == 1) {
                        que.offer(i);
                    }
                }
                size--;
            }
        }
        res.addAll(que);
        return res;
    }
}
