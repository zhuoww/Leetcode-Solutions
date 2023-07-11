import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = 0;
        int left = 0;
        int minLen = s.length() + 1;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) == 0)
                    matched++;
            }

            while (matched == map.size()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                }
                char removed = s.charAt(left);
                if (map.containsKey(removed)) {
                    if (map.get(removed) == 0)
                        matched--;
                    map.put(removed, map.get(removed) + 1);
                }
                left++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}
