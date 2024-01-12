/*
 * easy
 * time:O(n);space:O(1)
 */

class Solution {
    public boolean halvesAreAlike(String s) {
        if (s == null || s.length() == 0)
            return true;
        int len = s.length();

        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int l = 0;
        int r = len - 1;
        int leftCount = 0;
        int rightCount = 0;

        while (l < r) {
            if (set.contains(s.charAt(l))) {
                leftCount++;
            }
            if (set.contains(s.charAt(r))) {
                rightCount++;
            }
            l++;
            r--;
        }
        return leftCount == rightCount;
    }
}
