import java.util.HashMap;

class Solution {
    public int largestVariance(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;

        for (char c1 : map.keySet()) {
            for (char c2 : map.keySet()) {
                if (c1 == c2)
                    continue;
                int c1Freq = 0;
                int c2Freq = 0;
                int c1Remaining = map.get(c1);

                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == c1) {
                        c1Freq++;
                        c1Remaining--;
                    }
                    if (s.charAt(i) == c2) {
                        c2Freq++;
                    }
                    if (c2Freq < c1Freq && c1Remaining > 0) {
                        c2Freq = 0;
                        c1Freq = 0;
                    }
                    if (c1Freq > 0 && c2Freq > 0) {
                        max = Math.max(max, c2Freq - c1Freq);
                    }
                }
            }
        }
        return max;
    }
}
