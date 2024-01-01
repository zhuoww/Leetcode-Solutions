/*
 * medium
 * time:O(n);space:O(1)
 */

class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int num : data) {
            totalOnes += num;
        }

        int curOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (data[i] == 1) {
                curOnes++;
            }
        }
        int minSwaps = totalOnes - curOnes;
        for (int i = 1; i <= data.length - totalOnes; i++) {
            if (data[i - 1] == 1) {
                curOnes--;
            }
            if (data[i + totalOnes - 1] == 1) {
                curOnes++;
            }
            minSwaps = Math.min(minSwaps, totalOnes - curOnes);
        }
        return minSwaps;

    }
}