package Heap;

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // maxHeap
        // time: O(nlogn)--each insertion operation (maxHeap.offer(stone)) takes O(logn)
        // time, and there are n stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            int newStone = first - second;

            if (newStone > 0) {
                maxHeap.offer(newStone);
            }
        }
        return maxHeap.size() != 0 ? maxHeap.peek() : 0;
    }
}
