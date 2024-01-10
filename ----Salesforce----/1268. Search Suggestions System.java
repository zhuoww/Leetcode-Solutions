/*
 * medium
 * time: O(N * log(N)); sorting
 * space: O(N), where N is the length of the searchWord; res list can have a size proportional to the length of the searchWord
 */

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);

        int len = searchWord.length();
        int l = 0;
        int r = products.length - 1;

        // iterate each char in the searchWord
        for (int i = 0; i < len; i++) {
            char c = searchWord.charAt(i);
            while (l <= r && (i >= products[l].length() || products[l].charAt(i) != c)) {
                l++;
            }
            while (l <= r && (i >= products[r].length() || products[r].charAt(i) != c)) {
                r--;
            }

            int windowSize = r - l + 1;
            List<String> list = new ArrayList<>();
            for (int j = 0; j < Math.min(windowSize, 3); j++) {
                list.add(products[l + j]);
            }
            res.add(list);
        }
        return res;
    }
}