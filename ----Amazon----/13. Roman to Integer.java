/*
 * easy
 * time:O(n);space:O(n)
 */

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length() && map.get(c) < map.get(s.charAt(i + 1))) {
                res -= map.get(c);
            } else {
                res += map.get(c);
            }
        }
        return res;
    }
}
