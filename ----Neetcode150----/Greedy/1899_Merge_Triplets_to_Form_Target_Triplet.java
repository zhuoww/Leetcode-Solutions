package Greedy;

class Solution {
    // time: O(n)
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] res = new boolean[3];

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
                continue;
            for (int j = 0; j < 3; j++) {
                if (triplets[i][j] == target[j]) {
                    res[j] = true;
                }
            }
        }
        return res[0] && res[1] && res[2];
    }
}
