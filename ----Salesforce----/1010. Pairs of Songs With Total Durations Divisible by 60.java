/*
 * medium
 * time:O(n),N is the size of the time array
 * space:O(1)
 * The last test case is time 60 repeated 60000 times, which would make the count exceed the int limit in Java. 
 * Be cautious and use a long[] to store the counts.
 */

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long[] count = new long[60];// 0-59, index is remainder, value is count

        for (int t : time) {
            count[t % 60]++;
        }

        int res = 0;
        res += (count[0] * (count[0] - 1)) / 2;
        res += (count[30] * (count[30] - 1)) / 2;

        for (int i = 1; i <= 29; i++) {
            res += (count[i] * count[60 - i]);
        }

        return res;

    }
}