class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int sign = 1; // record sign
        int i = 0;
        long res = 0; // use long to avoid int overflow

        // skip leading whitespace
        while (i < len && s.charAt(i) == ' ')
            i++;
        if (i == len)
            return 0;

        // check if the character is '-' or '+'
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        if (i == len)
            return 0;

        // calculate digits
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            res = res * 10 + s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }

        // if it overflows, it will be different from the real value if it is forced to
        // int
        if ((int) res != res) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
