class Solution {
    public int search(int[] nums, int target) {
        // time: O(log n)--n is the size of the array. In each iteration, the search
        // range is halved
        // space: O(1)--the variables left, right, and mid are all individual integers,
        // and their memory consumption does not depend on the size of the input array
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }
}
