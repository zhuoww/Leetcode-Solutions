class MonotonicQueue {
    Deque<Integer> que = new LinkedList<>();

    public void add(int i) {
        while (!que.isEmpty() && i > que.getLast()) {
            que.removeLast();
        }
        que.add(i);
    }

    public void poll(int i) {
        if (!que.isEmpty() && i == que.peek()) {
            que.poll();
        }
    }

    public int peek() {
        return que.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        MonotonicQueue q = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        res[index++] = q.peek();

        for (int i = k; i < nums.length; i++) {
            q.poll(nums[i - k]);
            q.add(nums[i]);
            res[index++] = q.peek();

        }
        return res;
    }
}
