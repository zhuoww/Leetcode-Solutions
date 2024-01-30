/*
 * medium
 * time:O(n); space:O(n)
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        if (tokens == null || tokens.length == 0)
            return 0;

        for (String s : tokens) {
            if (s.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (s.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}