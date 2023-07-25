import java.util.Deque;
import java.util.LinkedList;

//The MonotonicQueue class is used to maintain a monotonic decreasing order of elements
class MonotonicQueue {
    Deque<Integer> deque = new LinkedList<>();

    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;

        MonotonicQueue que = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        // adds the first k elements of nums to que
        for (int i = 0; i < k; i++) {
            que.add(nums[i]);
        }
        res[index++] = que.peek();

        // iterates from k to the end of nums
        for (int i = k; i < nums.length; i++) {
            que.poll(nums[i - k]);
            que.add(nums[i]);
            res[index++] = que.peek();
        }
        return res;

    }
}
