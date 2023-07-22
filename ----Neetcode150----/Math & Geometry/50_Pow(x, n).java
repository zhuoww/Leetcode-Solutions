class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1 / helper(x, -(long) n);// Integer.MIN_VALUE: -2^31 (-2147483648); Integer.MAX_VALUE: 2^31 - 1
                                            // (2147483647);
        }
        return helper(x, n);
    }

    public double helper(double x, long n) {
        double res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

}
