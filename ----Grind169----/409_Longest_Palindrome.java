class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];

        for (Character c : s.toCharArray()) {
            counts[c]++;
        }

        int res = 0;
        for (int count : counts) {
            res += count / 2 * 2;
            if (res % 2 == 0 && count % 2 == 1)
                res++;
        }
        return res;
    }
}
