/*
 * easy
 */

//Brian Kernighan's Algorithm
//time: O(k), where k is the number of set bits in the binary representation of the given integer
//space: O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);// clears the rightmost set bit in n
            count++;
        }
        return count;
    }
}

// Bit Manipulation
// time:O(log n), where n is the value of the input number
// space:O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}