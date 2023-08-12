
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            res[t.charAt(i) - 'a']--;
        }
        for (int c : res) {
            if (c != 0)
                return false;
        }
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] count = new int[26];
        for (Character c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (Character c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }
}

// follow-up question
// HashMap
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }

        }
        return map.isEmpty();
    }
}