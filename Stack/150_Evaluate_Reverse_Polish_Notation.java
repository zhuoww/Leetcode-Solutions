package Stack;

import java.util.Stack;

//Infix notation: 3 + 4 * 2；RPN notation（Reverse Polish Notation）: 3 4 2 * +
//time:O(n)/space:O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (token.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (token.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (token.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}