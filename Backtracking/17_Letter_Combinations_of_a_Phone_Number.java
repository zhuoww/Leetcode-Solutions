package Backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

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
        String s = map[digit];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

/*
 * In Java, characters are represented as Unicode values, where the characters
 * '0' to '9'
 * have consecutive Unicode values. By subtracting the Unicode value of '0' from
 * the Unicode
 * value of the character digit, the code obtains the numerical value of the
 * digit.
 * 
 * For example, let's say digits.charAt(index) returns the character '3'. The
 * Unicode value
 * of '3' is 51, and the Unicode value of '0' is 48. So, digits.charAt(index) -
 * '0' would evaluate
 * to 51 - 48, which is 3, the corresponding numerical value of the character
 * '3'.
 */

/*
 * The deleteCharAt() method is a method of the StringBuilder class in Java. It
 * is
 * used to remove a character from a StringBuilder object at a specified index.
 */
