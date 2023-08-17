class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        int len = words.length;

        for (int i = 0; i < len; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (word.length() == 0)
                continue;
            int n = word.length();

            for (int j = 0; j <= n; j++) {
                if (isPalindrome(word, j, n - 1)) {
                    int leftIndex = findWord(word, 0, j - 1);
                    if (leftIndex != -1 && leftIndex != i) {
                        res.add(Arrays.asList(i, leftIndex));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightIndex = findWord(word, j, n - 1);
                    if (rightIndex != -1 && rightIndex != i) {
                        res.add(Arrays.asList(rightIndex, i));
                    }
                }
            }
        }
        return res;
    }

    public int findWord(String s, int left, int right) {
        String str = new StringBuilder(s.substring(left, right + 1)).reverse().toString();
        return map.getOrDefault(str, -1);
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
