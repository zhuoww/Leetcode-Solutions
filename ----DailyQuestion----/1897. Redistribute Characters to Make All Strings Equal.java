/*
 * easy
 * time:O(m*n);where n is the number of strings in the array and m is the average length of the strings.
 * space:O(c), where c is the number of unique characters across all strings.
 */

class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = words.length;

        for (String s : words) {
            for (Character c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % len != 0) {
                return false;
            }
        }

        return true;
    }
}