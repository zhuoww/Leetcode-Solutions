//stack: time-O(n + m), space-O(n + m)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                st1.push(c);
            } else {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            }
        }

        for (char c : t.toCharArray()) {
            if (c != '#') {
                st2.push(c);
            } else {
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            }
        }

        return st1.equals(st2);

    }
}

// two pointers
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int pointerS = s.length() - 1;
        int pointerT = t.length() - 1;

        int spaceS = 0;
        int spaceT = 0;

        while (pointerS >= 0 || pointerT >= 0) {
            while (pointerS >= 0) {
                if (s.charAt(pointerS) == '#') {
                    pointerS--;
                    spaceS++;
                } else if (spaceS > 0) {
                    pointerS--;
                    spaceS--;
                } else {
                    break;
                }
            }

            while (pointerT >= 0) {
                if (t.charAt(pointerT) == '#') {
                    pointerT--;
                    spaceT++;
                } else if (spaceT > 0) {
                    pointerT--;
                    spaceT--;
                } else {
                    break;
                }
            }

            if (pointerS >= 0 && pointerT >= 0 && s.charAt(pointerS) != t.charAt(pointerT))
                return false;
            if ((pointerS >= 0) != (pointerT >= 0))
                return false;

            pointerS--;
            pointerT--;
        }
        return true;
    }
}
