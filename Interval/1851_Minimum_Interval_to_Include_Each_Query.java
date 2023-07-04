package Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = i;
            q[i][1] = queries[i];
        }
        Arrays.sort(q, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int[] res = new int[queries.length];
        int j = 0;

        for (int i = 0; i < q.length; i++) {
            int index = q[i][0];
            int val = q[i][1];

            while (j < intervals.length && intervals[j][0] <= val) {
                minHeap.offer(intervals[j]);
                j++;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < val) {
                minHeap.poll();
            }
            res[index] = minHeap.isEmpty() ? -1 : minHeap.peek()[1] - minHeap.peek()[0] + 1;
        }
        return res;

    }
}
