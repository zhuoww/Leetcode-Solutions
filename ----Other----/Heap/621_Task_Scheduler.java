package Heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // maxheap
        // time: O(nlogn)--adding each element to the max heap takes O(log n) time and
        // there are n elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        int[] charMap = new int[26];
        for (char c : tasks) {
            charMap[c - 'A']++;
        }
        for (int frequent : charMap) {
            if (frequent > 0) {
                maxHeap.add(frequent);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty() || !que.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int val = maxHeap.poll();
                val--;
                if (val > 0) {
                    que.add(new Pair(val, time + n));
                }
            }

            if (!que.isEmpty() && que.peek().getValue() == time) {
                maxHeap.add(que.poll().getKey());
            }
        }
        return time;

    }
}
