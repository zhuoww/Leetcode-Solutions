//method1
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

// method2
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