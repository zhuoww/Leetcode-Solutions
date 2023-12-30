/*
 * medium
 * time: O(sqrt(n)); space:O(1)
 * If i is a divisor of n, then n / i is a divisor of n as well. Consequently, 
 * we can find all the divisors of n only by processing the numbers that are 
 * smaller or equal to the square root of n.
 */

class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }

        // k>0
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % (n / i) == 0 && --k == 0) {
                return n / i;
            }
        }
        return -1;
    }
}

// time:O(n); space:O(1)
class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            int remainder = n % i;
            if (remainder == 0 && --k == 0) {
                return i;
            }
        }
        return -1;
    }
}
