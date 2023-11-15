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

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charMap = new int[26];// store the frequency of each task
        for (char c : tasks) {
            charMap[c - 'A']++;
        }

        Arrays.sort(charMap);// O(nlogn)
        int maxFrequent = charMap[25] - 1;
        int idleSlots = maxFrequent * n;

        for (int i = 24; i >= 0 && charMap[i] > 0; i--) {
            idleSlots -= Math.min(charMap[i], maxFrequent);
        }

        idleSlots = Math.max(0, idleSlots); // make sure idleSlots is non-negative

        return idleSlots + tasks.length;
    }
}