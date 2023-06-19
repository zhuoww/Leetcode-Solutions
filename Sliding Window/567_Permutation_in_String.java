import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        // 1. edge case
        if (len1 > len2)
            return false;

        // 2. hash
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < len1; i++) {// counts the occurrences of characters in both s1 and s2
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        // 3. sliding window
        int l = 0;
        int r = len1 - 1;

        while (r < len2) {
            if (Arrays.equals(arr1, arr2))
                return true;
            r++;
            if (r != len2) {
                arr2[s2.charAt(r) - 'a']++;
            }
            arr2[s2.charAt(l) - 'a']--;
            l++;
        }
        return false;

    }

}