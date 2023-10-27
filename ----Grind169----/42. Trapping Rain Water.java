class Solution {
    public int trap(int[] height) {
        // Monotonic Increasing Stack
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

class Solution {
    public int trap(int[] height) {
        // two pointers
        if (height.length <= 2)
            return 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int area = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                area += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                area += rightMax - height[r];
            }
        }
        return area;
    }
}