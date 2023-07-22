package Stack;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotonic decreasing stack
        // time:O(n)--n is the length of the temperatures array
        // space: O(n)--stack can hold at most n elements
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];
        st.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[st.peek()]) {// haven't found a warmer temperature yet
                st.push(i);
            } else {
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {// found a warmer temperature
                    res[st.peek()] = i - st.peek();
                    st.pop();
                }
                st.push(i);
            }
        }
        return res;
    }
}