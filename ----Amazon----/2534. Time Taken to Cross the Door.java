/*
 * hard
 * time:O(m+n);space:O(m+n)
 */

class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;

        int[] res = new int[n];
        int prev = 1;
        int index = 0;
        int time = 0;

        while (index < n || !enter.isEmpty() || !exit.isEmpty()) {
            while (index < n && arrival[index] == time) {
                if (state[index] == 0) {
                    enter.add(index);
                } else {
                    exit.add(index);
                }
                index++;
            }

            if (!exit.isEmpty() && (prev == 1 || enter.isEmpty())) {
                res[exit.poll()] = time;
                prev = 1;
            } else if (!enter.isEmpty()) {
                res[enter.poll()] = time;
                prev = 0;
            } else {
                prev = 1;
            }
            time++;
        }
        return res;
    }
}
