class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        int j = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            res[j++] = cur;

            if (map.containsKey(cur)) {
                for (int neighbor : map.get(cur)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        que.offer(neighbor);
                    }
                }
            }
        }
        return j == numCourses ? res : new int[0];

    }
}
