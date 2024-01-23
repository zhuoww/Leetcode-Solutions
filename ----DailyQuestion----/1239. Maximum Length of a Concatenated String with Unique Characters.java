/*
 * medium
 * time: O(2^n) because I choose or not choose each string for every previous choice
 * space: O(n) because I will keep a set of all string characters, and the longest set at any point will contain atmost 26 characters
 */

class Solution {
    int res = 0;

    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return res;
    }

    public void dfs(List<String> arr, String s, int index) {
        if (index == arr.size()) {
            return;
        }

        if (isValid(s + arr.get(index))) {
            dfs(arr, s + arr.get(index), index + 1);
        }
        dfs(arr, s, index + 1);
    }

    public boolean isValid(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                return false;
            set.add(c);
        }
        res = Math.max(res, s.length());
        return true;
    }
}
