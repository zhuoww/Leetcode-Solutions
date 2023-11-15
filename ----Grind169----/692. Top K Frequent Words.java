class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Pair<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue() != b.getValue()) {
                return a.getValue() - b.getValue();
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.add(new Pair(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        ArrayList<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll().getKey());
        }
        return res;
    }
}
