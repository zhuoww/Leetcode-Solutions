class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int l = 0;
        int r = 0;
        int count = k;
        int res = 0;

        while (r < answerKey.length()) {
            if (answerKey.charAt(r) == 'T')
                count--;
            if (count < 0) {
                if (answerKey.charAt(l) == 'T') {
                    count++;
                }
                l++;
            }
            r++;
            res = Math.max(res, r - l);
        }

        l = 0;
        r = 0;
        while (r < answerKey.length()) {
            if (answerKey.charAt(r) == 'F')
                k--;
            if (k < 0) {
                if (answerKey.charAt(l) == 'F') {
                    k++;
                }
                l++;
            }
            r++;
            res = Math.max(res, r - l);
        }
        return res;
    }
}
