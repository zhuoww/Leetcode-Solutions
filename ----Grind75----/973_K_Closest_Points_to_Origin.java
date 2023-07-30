class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // maxHeap
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            pq.offer(point);// each insertion takes O(logk) time, and there are n points
            if (pq.size() > k) {
                pq.poll();// takes O(logk) time, performed at most n-k times
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;

    }
}