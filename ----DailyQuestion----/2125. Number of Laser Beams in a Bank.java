/*
 * medium
 * time:O(m*n);space:O(1)
 */

class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank == null || bank.length == 0)
            return 0;
        int pre = 0;
        int res = 0;
        for (String s : bank) {
            int count = 0;
            for (Character c : s.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }

            if (count == 0) {
                continue;
            } else {
                res += pre * count;
                pre = count;
            }
        }
        return res;

    }
}