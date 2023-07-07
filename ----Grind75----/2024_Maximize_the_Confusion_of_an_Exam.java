//mehtod 1
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // time: O(n)
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

// method 2
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] freq = new int[2];
        int res = 0;
        int maxFreq = 0;
        int l = 0;

        for (int r = 0; r < answerKey.length(); r++) {
            if (answerKey.charAt(r) == 'T') {
                freq[0]++;
            } else {
                freq[1]++;
            }

            maxFreq = Math.max(freq[0], freq[1]);

            if (r - l + 1 - maxFreq > k) {
                if (answerKey.charAt(l) == 'T') {
                    freq[0]--;
                } else {
                    freq[1]--;
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
