import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // time: O(nlogk)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            maxHeap.offer(point);// each insertion operation (maxHeap.offer(point)) takes O(logk) time, and there
                                 // are n points
            if (maxHeap.size() > k) {
                maxHeap.poll();// maxHeap.poll() takes O(logk) time. This operation is performed at most n-k
                               // times
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
