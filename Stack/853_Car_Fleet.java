package Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // monotonic increasing stack
        // time: O(nlogn)--n is the number of cars, sorting operation performed on the
        // array
        // space; O(n)--stack can hold at most n elements in the worst-case scenario
        if (position.length == 1)
            return 1;
        Stack<Double> st = new Stack<>();
        int[][] pairArr = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairArr[i][0] = position[i];
            pairArr[i][1] = speed[i];
        }

        Arrays.sort(pairArr, Comparator.comparingInt(a -> a[0]));

        for (int i = pairArr.length - 1; i >= 0; i--) {
            Double time = (double) (target - pairArr[i][0]) / pairArr[i][1];
            if (!st.isEmpty() && time <= st.peek()) { // the current car can catch up to the car ahead, forming a fleet
                continue;
            } else {
                st.push(time);// won't catch, create new fleet
            }
        }
        return st.size();

    }
}
