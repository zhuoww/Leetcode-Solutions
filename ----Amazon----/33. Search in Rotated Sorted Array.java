/*
 * medium
 * time:O(logn);space:O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[len - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int min = l;
        if (target <= nums[len - 1]) {
            l = min;
            r = len - 1;
        } else {
            l = 0;
            r = min - 1;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
