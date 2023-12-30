/*
 * medium
 * time:O(n);space:O(1)
 */

class Solution {
    public int partitionString(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 1;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res++;
                set.clear();
            }
            set.add(s.charAt(i));
        }
        return res;
    }
}

// dp
class Solution {
    public int partitionString(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
                set.clear();
            }
            set.add(s.charAt(i));
        }
        return dp[s.length() - 1];

    }
}