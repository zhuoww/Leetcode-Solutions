class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] char_map = new int[26];

        for (char c : tasks) {
            char_map[c - 'A']++;
        }

        for (int frequency : char_map) {
            if (frequency > 0) {
                maxHeap.add(frequency);
            }
        }

        int count = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            count++;
            if (!maxHeap.isEmpty()) {
                int val = maxHeap.poll();
                val--;
                if (val > 0) {
                    q.add(new Pair(val, count + n));
                }
            }

            if (!q.isEmpty() && q.peek().getValue() == count) {
                maxHeap.add(q.poll().getKey());
            }
        }
        return count;

    }
}