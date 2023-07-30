class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int len = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        int[] leftLimit = new int[len];
        int[] rightLimit = new int[len];

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

        while (!st.isEmpty()) {
            st.pop();
        }

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

        for (int i = 0; i < len; i++) {
            int h = heights[i];
            int w = rightLimit[i] - leftLimit[i] + 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;

    }
}
