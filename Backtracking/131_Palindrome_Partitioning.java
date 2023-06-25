package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // combination problem： collect results at leaf nodes
    // startIndex: avoid getting the same elements
    LinkedList<String> path = new LinkedList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {// collect results at leaf nodes
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }

            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
