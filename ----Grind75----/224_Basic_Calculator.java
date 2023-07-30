class Solution {
    public int calculate(String s) {
        int sign = 1;
        int sum = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                sum += num * sign;
                i--;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                sum = st.pop() * sum;
                sum += st.pop();
            }
        }
        return sum;
    }
}
