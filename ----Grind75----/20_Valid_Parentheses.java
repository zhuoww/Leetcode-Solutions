import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Tips: stack, even
        // time: O(n)
        // space: O(n)
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(')');
            } else if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.peek() != ch) {
                return false;
            } else {
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
