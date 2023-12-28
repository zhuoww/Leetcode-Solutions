/*
 * medium
 * backtracking
 */

class Solution {
    List<String> res = new ArrayList<>();
    String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return res;
        backtracking(digits, 0);
        return res;
    }

    public void backtracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String s = letters[digit];

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}