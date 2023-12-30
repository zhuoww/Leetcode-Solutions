/*
 * medium
 * time:O(logn);space:O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int smallest = l;
        l = 0;
        r = nums.length - 1;
        if (target >= nums[smallest] && target <= nums[r]) {
            l = smallest;
        } else {
            r = smallest - 1;
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
