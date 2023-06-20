package Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class Solution {
    // stack, backtracing
    Stack<String> st = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return res;
    }

    public void backtracking(int open, int close, int n) {
        if (open == close && close == n) {// valid: open == close == n
            Iterator val = st.iterator();// iterates over the elements of the stack and returns the values(iterators)
            String temp = "";
            while (val.hasNext()) {// hasNext(): returns true if next() would return an element rather than
                                   // throwing an exception
                temp += val.next();// next(): returns the next element in the iteration.
            }
            res.add(temp);
        }

        if (open < n) {// only add open parentheses if open < n
            st.push("(");
            backtracking(open + 1, close, n);
            st.pop();
        }

        if (close < open) {// only add close parentheses if close < open
            st.push(")");
            backtracking(open, close + 1, n);
            st.pop();
        }
    }
}
