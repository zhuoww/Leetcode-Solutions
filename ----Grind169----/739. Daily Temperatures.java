class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        if (len == 0)
            return res;
        if (len == 1)
            res[0] = 0;

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < len; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}
