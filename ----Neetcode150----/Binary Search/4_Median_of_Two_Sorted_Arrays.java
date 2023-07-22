class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // time: O(log min(len1, len2))--search on the smaller array to find the correct
        // partition position

        // space: O(1)
        // swap arrays, so that nums1 is always the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLeft = (len1 + len2) / 2;

        // search position of the partition in nums1 between [0, len1]
        int left = 0;
        int right = len1;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = totalLeft - i;

            // determine the maximum value on the left side and the minimum value on the
            // right side
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];// (i == 0), there is no element on the left
                                                                           // side
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums1RightMin = (i == len1) ? Integer.MAX_VALUE : nums1[i];// (i == len1), there is no element on the
                                                                           // right side
            int nums2RightMin = (j == len2) ? Integer.MAX_VALUE : nums2[j];

            // check if the current partition is valid or needs adjustment
            if (nums1LeftMax > nums2RightMin) {
                right = i - 1;
            } else if (nums2LeftMax > nums1RightMin) {
                left = i + 1;
            } else {// found the correct partition
                // calculate the median based on even or odd total number of elements
                if ((len1 + len2) % 2 == 0) {
                    return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
                } else {
                    return Math.min(nums1RightMin, nums2RightMin);
                }
            }
        }
        return -1;
    }

}
