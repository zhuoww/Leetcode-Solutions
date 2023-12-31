/*
 * easy
 */

//hashmap
//time:O(n);space:O(26)
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                res = Math.max(res, i - map.get(c) - 1);
            }
        }
        return res;

    }
}

// two pointers
// time:O(n^2);space:O(1)
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int l = 0;
        int r = s.length() - 1;
        int res = -1;

        while (l < r) {
            while (l < r) {
                if (s.charAt(r) == s.charAt(l)) {
                    res = Math.max(res, r - l - 1);
                    break;
                } else {
                    r--;
                }
            }
            l++;
            r = s.length() - 1;
        }
        return res;
    }
}
