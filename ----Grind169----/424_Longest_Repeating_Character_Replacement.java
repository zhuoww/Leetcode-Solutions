
class Solution {

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int res = 0;
        int maxFre = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFre = Math.max(maxFre, freq[s.charAt(r) - 'A']);

            if ((r - l + 1) - maxFre > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;

    }
}