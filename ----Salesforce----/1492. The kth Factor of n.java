/*
 * medium
 */

//sqrt(n): time:O(sqrt(n));space:O(1)
class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }

        // k > 0
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0 && --k == 0) {
                return n / i;
            }
        }

        return -1;
    }
}

// time:O(n);space:O(1)
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
