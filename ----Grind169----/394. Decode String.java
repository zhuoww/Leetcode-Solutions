class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                String substr = "";
                while (stack.peek() != '[') {
                    substr = stack.pop() + substr;
                }
                stack.pop();

                String k = "";
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    k = stack.pop() + k;
                }

                int n = Integer.valueOf(k);
                String repeatStr = "";
                for (int i = 0; i < n; i++) {
                    repeatStr += substr;
                }

                for (int i = 0; i < repeatStr.length(); i++) {
                    stack.push(repeatStr.charAt(i));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
