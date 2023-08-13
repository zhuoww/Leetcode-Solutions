class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() == 0)
            return res;
        HashMap<Character, Integer> map = new HashMap<>();
        // Step 1: Populate the HashMap 'map' with character frequencies from string 'p'
        for (Character c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int matched = 0; // Counter to keep track of matching characters

        // Step 2: Begin iterating through the characters of string 's'
        while (right < s.length()) {
            char r = s.charAt(right);
            right++; // Increment right to extend the window to the right

            // Check if the character 'r' exists in the HashMap 'map'
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1); // Decrement the character count in 'map'
                if (map.get(r) == 0)
                    matched++;
            }

            // Step 3: Inner loop to adjust window size and search for anagrams
            while (right - left >= p.length()) {
                if (matched == map.size()) {
                    res.add(left);
                }
                char l = s.charAt(left);
                left++;

                // Check if the character 'l' exists in the HashMap 'map'
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