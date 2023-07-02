package Greedy;

import java.util.PriorityQueue;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int card : hand) {
            minHeap.add(card);
        }

        while (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            for (int i = 1; i < groupSize; i++) {
                if (minHeap.remove(smallest + i))
                    continue;
                return false;
            }
        }
        return true;
    }
}
