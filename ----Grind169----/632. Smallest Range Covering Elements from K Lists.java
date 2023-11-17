class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).get(0) > max) {
                max = nums.get(i).get(0);
            }

            minHeap.offer(new int[] { nums.get(i).get(0), i, 0 });
        }

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[1];
            int j = cur[2];

            if (max - cur[0] < minRange) {
                minRange = max - cur[0];
                res[0] = cur[0];
                res[1] = max;
            }

            if (i < nums.size() && j + 1 < nums.get(i).size()) {
                minHeap.offer(new int[] { nums.get(i).get(j + 1), i, j + 1 });
                if (nums.get(i).get(j + 1) > max) {
                    max = nums.get(i).get(j + 1);
                }
            } else {
                break;
            }
        }
        return res;
    }
}
