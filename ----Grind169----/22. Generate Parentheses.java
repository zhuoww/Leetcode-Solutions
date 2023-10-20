class Solution {
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return res;
        backtracking(n, "(", 1, 0);
        return res;
    }

    public void backtracking(int n, String s, int open, int close) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (open < n) {
            backtracking(n, s + "(", open + 1, close);
        }
        if (close < open) {
            backtracking(n, s + ")", open, close + 1);
        }
    }
}