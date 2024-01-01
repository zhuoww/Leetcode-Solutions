/*
 * hard
 * time:O(NlogK);space:O(N+2*K)
 */

class Solution {
    public int kBigIndices(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        boolean[] valid = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() == k && pq.peek() < nums[i]) {
                valid[i] = true;
            }

            pq.add(nums[i]);
            if (pq.size() > k)
                pq.poll();
        }

        int res = 0;
        pq.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (pq.size() == k && pq.peek() < nums[i] && valid[i]) {
                res++;
            }

            pq.add(nums[i]);
            if (pq.size() > k)
                pq.poll();
        }
        return res;

    }
}