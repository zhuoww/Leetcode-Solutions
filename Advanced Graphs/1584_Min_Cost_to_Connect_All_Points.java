import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        HashSet<Integer> visited = new HashSet<>();
        int cost = 0;

        minHeap.offer(new int[] { 0, 0 });

        while (visited.size() < points.length) {
            int[] cur = minHeap.poll();
            int curCost = cur[0];
            int curPoint = cur[1];

            if (visited.contains(curPoint))
                continue;
            visited.add(curPoint);
            cost += curCost;

            for (int i = 1; i < points.length; i++) {
                if (!visited.contains(i)) {
                    int weight = Math.abs(points[i][0] - points[curPoint][0])
                            + Math.abs(points[i][1] - points[curPoint][1]);
                    minHeap.offer(new int[] { weight, i });
                }
            }
        }
        return cost;
    }
}
