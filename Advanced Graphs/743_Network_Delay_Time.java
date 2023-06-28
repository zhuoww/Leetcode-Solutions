import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // BFS
        // Queue
        HashMap<Integer, List<int[]>> map = new HashMap<>();// store the targetNode and weight of each node
        for (int[] time : times) {
            if (!map.containsKey(time[0])) {
                map.put(time[0], new LinkedList<int[]>());
            }
            map.get(time[0]).add(new int[] { time[1], time[2] });
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[] { k, 0 });
        HashSet<Integer> visited = new HashSet<>();
        int res = 0;

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int srcNode = cur[0];
            int srcWeight = cur[1];

            if (visited.contains(srcNode))
                continue;
            visited.add(srcNode);

            res = srcWeight;

            if (!map.containsKey(srcNode))
                continue;

            for (int[] neighbor : map.get(srcNode)) {
                int target = neighbor[0];
                int tarWeight = neighbor[1];
                minHeap.offer(new int[] { target, tarWeight + srcWeight });
            }
        }
        return visited.size() == n ? res : -1;

    }
}
