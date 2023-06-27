package Graphs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // DFS
        List<List<Integer>> list = new ArrayList<>();// store the prerequisites of each course
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];// 0--not visited, 1--visited and completed, 2--visited but not completed
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(list, visited, i)) {
                return false;
            }
        }
        return true;

    }

    public boolean dfs(List<List<Integer>> list, int[] visited, int index) {
        if (visited[index] == 2)
            return true;// there is a cycle

        visited[index] = 2;// marked as visited but not completed
        for (int i = 0; i < list.get(index).size(); i++) {// iterate prerequisites of each course
            int num = list.get(index).get(i);// each prerequisites
            if (visited[num] != 1) {// check if the course has not been completed(0 or 2)
                if (dfs(list, visited, num)) {
                    return true;// there is a cycle
                }
            }
        }
        visited[index] = 1;// indicates that it has been visited and completed
        return false;// no cycle
    }

}
