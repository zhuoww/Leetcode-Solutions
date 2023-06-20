package Stack;

import java.util.Stack;

//histogram: 直方图
class Solution {
    public int largestRectangleArea(int[] heights) {
        // monotonic increasing stack
        // time: O(n)--n is the length of the heights array, 2 loops(left->right,
        // right->left)
        // space; O(n)--a stack and two auxiliary arrays, each with a length equal to
        // the input array heights
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int len = heights.length;
        Stack<Integer> st = new Stack<>();

        // store the left and right limits of each bar's rectangle
        int[] leftLimit = new int[len];
        int[] rightLimit = new int[len];
        int maxArea = 0;

        // calculates the left limit of each bar
        for (int i = 0; i < len; i++) {
            if (st.isEmpty()) {
                leftLimit[i] = 0;
                st.push(i);
            } else {
                while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                    st.pop();
                }
                leftLimit[i] = st.isEmpty() ? 0 : st.peek() + 1;
                st.push(i);
            }
        }

        // the stack is cleared to be reused for the second loop
        while (!st.isEmpty()) {
            st.pop();
        }

        // calculates the right limit of each bar
        for (int i = len - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                rightLimit[i] = len - 1;
                st.push(i);
            } else {
                while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                    st.pop();
                }
                rightLimit[i] = st.isEmpty() ? len - 1 : st.peek() - 1;
                st.push(i);
            }
        }

        // calculates the area of each rectangle
        for (int i = 0; i < len; i++) {
            int h = heights[i];
            int w = rightLimit[i] - leftLimit[i] + 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }
}
