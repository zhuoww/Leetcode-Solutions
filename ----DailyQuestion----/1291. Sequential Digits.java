/*
 * medium
 * time:O(1);space:O(1)
 */

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int len_low = Integer.toString(low).length();
        int len_high = Integer.toString(high).length();

        for (int i = len_low; i <= len_high; i++) {
            for (int start = 1; start < 9; start++) {
                if (start + i > 10) {
                    break;
                }
                int num = start;
                int next = start;

                for (int j = 0; j < i - 1; j++) {
                    next++;
                    num = num * 10 + next;
                }
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}

// queue
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur > high)
                continue;
            if (cur <= high && cur >= low) {
                res.add(cur);
            }

            int digit = cur % 10;
            if (digit < 9) {
                q.offer(cur * 10 + (digit + 1));
            }
        }
        return res;
    }
}
