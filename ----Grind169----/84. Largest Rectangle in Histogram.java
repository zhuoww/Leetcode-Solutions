class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int[] leftLimit = new int[n];
        int[] rightLimit = new int[n];

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
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

        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                rightLimit[i] = n - 1;
                st.push(i);
            } else {
                while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                    st.pop();
                }
                rightLimit[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
                st.push(i);
            }
        }

        for (int i = 0; i < n; i++) {
            int h = heights[i];
            int w = rightLimit[i] - leftLimit[i] + 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;

    }
}
