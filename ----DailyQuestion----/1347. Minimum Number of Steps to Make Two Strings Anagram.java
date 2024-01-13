/*
 * medium
 * time:O(n);space:O(1)
 */

class Solution {
    public int minSteps(String s, String t) {
        int min = 0;
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i) - 'a'] > 0) {
                count[t.charAt(i) - 'a']--;
            } else {
                min++;
            }
        }
        return min;
    }
}
