/*
 * medium
 * time: O(log n), since the input is getting reduced by a factor of 10 in each iteration.
 * space:O(1)
 */

class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int res = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (res > max / 10 || res == max / 10 && digit > max % 10)
                return 0;
            if (res < min / 10 || res == min / 10 && digit < min % 10)
                return 0;
            res = (res * 10) + digit;
        }
        return res;
    }
}
