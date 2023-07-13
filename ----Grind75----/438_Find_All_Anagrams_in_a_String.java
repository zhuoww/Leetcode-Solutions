import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;

        int[] record = new int[26];
        for (Character c : p.toCharArray()) {
            record[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            if (record[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            record[s.charAt(right) - 'a']--;
            right++;
            if (count == 0)
                res.add(left);

            if (right - left == p.length()) {
                if (record[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                record[s.charAt(left) - 'a']++;
                left++;
            }

        }
        return res;

    }
}
