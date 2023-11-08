class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2)
            return 0;
        int l = 0;
        int r = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                max = Math.max(max, l * 2);
            } else if (r > l) {
                l = 0;
                r = 0;
            }

        }

        l = 0;
        r = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                max = Math.max(max, l * 2);
            } else if (l > r) {
                l = 0;
                r = 0;
            }
        }

        return max;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        // stack
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int len = i - st.peek();
                    max = Math.max(max, len);
                }
            }
        }
        return max;

    }
}
