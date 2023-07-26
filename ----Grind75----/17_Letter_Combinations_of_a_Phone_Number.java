class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
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
        String s = arr[digit];

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
