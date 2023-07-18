import java.util.ArrayList;

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
            if (isCyclic(list, visited, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCyclic(List<List<Integer>> list, int[] visited, int index) {
        if (visited[index] == 2)
            return true;

        visited[index] = 2;
        for (int i = 0; i < list.get(index).size(); i++) {
            int num = list.get(index).get(i);
            if (visited[num] != 1) {
                if (isCyclic(list, visited, num)) {
                    return true;
                }
            }
        }
        visited[index] = 1;
        return false;
    }
}
