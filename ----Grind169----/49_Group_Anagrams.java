class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return res;

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] hash = new int[26];
            for (Character c : s.toCharArray()) {
                hash[c - 'a']++;
            }

            String key = new String(Arrays.toString(hash));
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        res.addAll(map.values());
        return res;

    }
}