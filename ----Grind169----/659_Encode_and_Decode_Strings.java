public class Solution {
    /*
     * @param strs: a list of strings
     * 
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * 
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            int len = Integer.valueOf(str.substring(i, j));
            i = j + 1 + len;
            res.add(str.substring(j + 1, i));
        }
        return res;
    }
}
