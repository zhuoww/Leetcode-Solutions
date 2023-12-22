/*
 * easy
 */
//time:O(n);space:O(1)
class Solution {
    public int maxScore(String s) {
        int zeroes = 0;
        int ones = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroes++;
            } else {
                ones--;
            }
            res = Math.max(res, zeroes + ones);
        }
        return res;
    }
}

// dfs--not efficient
// time:O(n^2);space:O(n)-left/right
class Solution {
    public int maxScore(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            res = Math.max(res, helper(s, i));
        }
        return res;
    }

    public int helper(String s, int index) {
        String left = s.substring(0, index);
        String right = s.substring(index, s.length());
        int count = 0;

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == '0') {
                count++;
            }
        }

        for (int j = 0; j < right.length(); j++) {
            if (right.charAt(j) == '1') {
                count++;
            }
        }
        return count;
    }
}