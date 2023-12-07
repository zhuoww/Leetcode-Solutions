/*
 * easy
 * time: O(n); space: O(1)
 */

class Solution {
    public String largestOddNumber(String num) {
        if (num == null || num.length() == 0)
            return "";
        for (int i = num.length() - 1; i >= 0; i--) {
            int cur = num.charAt(i);
            if (cur % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
