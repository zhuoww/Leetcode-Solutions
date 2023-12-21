/*
 * easy
 */

//no string
//time:O(log(x)), where x is the input integer
//space:O(1)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        long reverse = 0;
        long temp = x;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return reverse == x;
    }
}

// string
// time:O(n);space:o(n)
class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
