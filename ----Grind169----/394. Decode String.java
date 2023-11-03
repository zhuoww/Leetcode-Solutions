//single stack
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

// two stacks
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String string = "";
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                stringStack.push(string);
                string = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(string);
                }
                string = temp.toString();
                index++;
            } else {
                string += s.charAt(index);
                index++;
            }
        }
        return string;
    }
}
