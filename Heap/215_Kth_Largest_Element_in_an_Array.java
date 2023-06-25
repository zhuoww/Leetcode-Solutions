import java.util.PriorityQueue;

//another method: quick select -- time: O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // minHeap--time: O(nlogk)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }
}
