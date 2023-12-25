/*
 * medium
 * time:O(n);space:O(n)
 * - The outer loop runs numRows times, which is a constant factor not dependent on the input size n
 */

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int increment = 2 * (numRows - 1);
            for (int j = i; j < s.length(); j += increment) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && j + increment - 2 * i < s.length()) {
                    sb.append(s.charAt(j + increment - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
