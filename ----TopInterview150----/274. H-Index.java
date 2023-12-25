/*
 * medium
 * 主要是看懂题目
 * time:O(nlogn);space:O(1)
 */

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int count = 1;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (count <= citations[i]) {
                count++;
            }
        }
        return count - 1;
    }
}