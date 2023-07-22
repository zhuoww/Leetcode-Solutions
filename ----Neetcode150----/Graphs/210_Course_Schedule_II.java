package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];// number of prerequisites for each course
        int[] order = new int[numCourses];

        for (int[] pre : prerequisites) {
            List<Integer> list = map.getOrDefault(pre[1], new ArrayList<>());
            list.add(pre[0]);
            map.put(pre[1], list);

            indegree[pre[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {// the courses that have no prerequisites
                que.add(i);
            }
        }

        int i = 0;
        while (!que.isEmpty()) {
            int node = que.poll();
            order[i++] = node;

            if (map.containsKey(node)) {
                for (Integer course : map.get(node)) {
                    indegree[course]--;

                    if (indegree[course] == 0) {
                        que.add(course);
                    }
                }
            }
        }

        return i == numCourses ? order : new int[0];

    }
}
