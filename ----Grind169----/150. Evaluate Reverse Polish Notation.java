class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        if (tokens == null)
            return 0;

        for (String t : tokens) {
            if (t.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (t.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (t.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (t.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
