/*
 * easy
 * time:O(n);space:O(1)
 */

class Solution {
    public int minOperations(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {// even index
                if (s.charAt(i) == '1') {
                    count++;
                }
            } else {// odd index
                if (s.charAt(i) == '0') {
                    count++;
                }
            }
        }
        return Math.min(count, len - count);
    }
}