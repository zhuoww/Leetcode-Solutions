class Solution {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int area = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[st.peek()]) {
                st.push(i);
            } else if (height[i] == height[st.peek()]) {
                st.pop();
                st.push(i);
            } else {
                while (!st.isEmpty() && height[i] > height[st.peek()]) {
                    int midIndex = st.pop();
                    if (!st.isEmpty()) {
                        int h = Math.min(height[i], height[st.peek()]) - height[midIndex];
                        int w = i - st.peek() - 1;
                        area += h * w;
                    }
                }
                st.push(i);
            }
        }
        return area;

    }

}