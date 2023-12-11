/*
 * easy
 * time:O(n);space:O(1)
 */
class Solution {
    public int findSpecialInteger(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        if (arr.length == 1)
            return arr[0];

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > arr.length / 4) {
                return arr[i];
            }
        }

        return -1;

    }
}

class Solution {
    public int findSpecialInteger(int[] arr) {
        int targetLen = arr.length / 4;

        for (int i = 0; i < arr.length - targetLen; i++) {
            if (arr[i] == arr[i + targetLen]) {
                return arr[i];
            }
        }

        return -1;

    }
}