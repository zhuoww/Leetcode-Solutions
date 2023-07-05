class Solution {
    // two pointer
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            Character start = s.charAt(l);
            Character end = s.charAt(r);
            if (!Character.isLetterOrDigit(start)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                r--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}
