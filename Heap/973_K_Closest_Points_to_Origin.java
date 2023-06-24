package Heap;

import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // time: O(nlogk)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = maxHeap.poll();
            res[i] = cur;
        }

        return res;

    }
}
