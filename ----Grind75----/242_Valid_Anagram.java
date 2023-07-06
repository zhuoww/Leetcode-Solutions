class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())// remember！！
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
