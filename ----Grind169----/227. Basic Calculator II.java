class Solution {
    public int calculate(String s) {
        int len = s.length();
        if (s == null || len == 0)
            return 0;

        Stack<Integer> st = new Stack<>();
        int num = 0;
        int res = 0;
        char sign = '+';

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // check for digit
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }

            // check for sign
            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                if (sign == '+') {
                    st.push(num);
                } else if (sign == '-') {
                    st.push(-num);
                } else if (sign == '*') {
                    st.push(st.pop() * num);
                } else if (sign == '/') {
                    st.push(st.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}