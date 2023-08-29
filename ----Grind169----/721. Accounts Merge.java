class Solution {
    int[] parent = new int[1001];

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            parent[i] = i;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> cur = accounts.get(i);
            for (int j = 1; j < cur.size(); j++) {
                if (!map.containsKey(cur.get(j))) {
                    map.put(cur.get(j), i);
                } else {
                    union(map.get(cur.get(j)), i);
                }
            }
        }

        List<String>[] res = new ArrayList[accounts.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res[find(entry.getValue())].add(entry.getKey());
        }

        List<List<String>> final_res = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            if (!res[i].isEmpty()) {
                final_res.add(new ArrayList<>());
                final_res.get(final_res.size() - 1).add(accounts.get(i).get(0));
                Collections.sort(res[i]);
                for (String email : res[i]) {
                    final_res.get(final_res.size() - 1).add(email);
                }
            }
        }
        return final_res;

    }

    private int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        parent[find(y)] = find(x);
    }
}