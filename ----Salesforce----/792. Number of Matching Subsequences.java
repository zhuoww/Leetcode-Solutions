/*
 * medium
 */

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int res = 0;

        for (String word : wordMap.keySet()) {
            boolean subseq = isSubseq(word, map);
            res = subseq == true ? res + wordMap.get(word) : res;
        }

        return res;
    }

    public boolean isSubseq(String word, HashMap<Character, List<Integer>> map) {
        int lastIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            if (map.get(word.charAt(i)) == null) {
                return false;
            } else {
                ArrayList<Integer> list = (ArrayList) map.get(word.charAt(i));
                int j = 0;
                while (list.get(j) <= lastIndex && j != list.size() - 1) {
                    j++;
                }
                if (list.get(j) <= lastIndex) {
                    return false;
                } else {
                    lastIndex = list.get(j);
                }
            }
        }
        return true;
    }
}
