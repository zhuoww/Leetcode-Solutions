/*
 * easy
 * int[]
 * time: O(m * n),m is the length of the chars string, and n is the length of the words array
 * space: O(1), 2 arrays of 26 elements
 */

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] letters = new int[26];
        for (char c : chars.toCharArray()) {
            letters[c - 'a']++;
        }

        int sum = 0;

        for (String word : words) {
            int[] copy = Arrays.copyOf(letters, 26);
            int index = 0;

            for (char x : word.toCharArray()) {
                if (copy[x - 'a'] > 0) {
                    copy[x - 'a']--;
                    index++;
                } else {
                    continue;
                }
            }
            if (index == word.length()) {
                sum += word.length();
            }

        }
        return sum;
    }
}

/*
 * HashMap
 * time: O(m * n),m is the length of the chars string, and n is the length of
 * the words array
 * space: O(k), k is the length of chars
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            if (isValid(word, new HashMap<>(map))) {
                sum += word.length();
            }
        }
        return sum;
    }

    public boolean isValid(String word, HashMap<Character, Integer> map) {
        for (char c : word.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }
}