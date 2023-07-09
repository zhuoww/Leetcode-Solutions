import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}
