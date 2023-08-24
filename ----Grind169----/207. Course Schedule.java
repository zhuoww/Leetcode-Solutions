class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCycle(list, visited, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCycle(List<List<Integer>> list, int[] visited, int index) {
        if (visited[index] == 2)
            return true;
        visited[index] = 2;

        for (int i = 0; i < list.get(index).size(); i++) {
            int curCourse = list.get(index).get(i);
            if (visited[curCourse] != 1) {
                if (isCycle(list, visited, curCourse)) {
                    return true;
                }
            }
        }

        visited[index] = 1;
        return false;
    }
}
