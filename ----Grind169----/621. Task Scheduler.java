class Solution {
    public int leastInterval(char[] tasks, int n) {
        // maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        int[] map = new int[26];

        for (char c : tasks) {
            map[c - 'A']++;
        }

        for (int freq : map) {
            if (freq > 0) {
                maxHeap.add(freq);
            }
        }

        int count = 0;
        while (!maxHeap.isEmpty() || !que.isEmpty()) {
            count++;
            if (!maxHeap.isEmpty()) {
                int cur = maxHeap.poll();
                cur--;
                if (cur > 0) {
                    que.add(new Pair(cur, count + n));
                }
            }

            if (!que.isEmpty() && que.peek().getValue() == count) {
                maxHeap.add(que.poll().getKey());
            }
        }
        return count;
    }
}
