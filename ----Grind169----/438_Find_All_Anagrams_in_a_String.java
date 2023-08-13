class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() == 0)
            return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int matched = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) == 0)
                    matched++;
            }

            while (right - left >= p.length()) {
                if (matched == map.size()) {
                    res.add(left);
                }
                char l = s.charAt(left);
                left++;
                if (map.containsKey(l)) {
                    if (map.get(l) == 0)
                        matched--;
                    map.put(l, map.get(l) + 1);
                }

            }
        }
        return res;
    }
}
