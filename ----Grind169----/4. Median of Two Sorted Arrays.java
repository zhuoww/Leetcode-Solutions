class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLeft = (len1 + len2) / 2;

        int l = 0;
        int r = len1;

        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = totalLeft - i;

            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == len1) ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == len2) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax > nums2RightMin) {
                r = i - 1;
            } else if (nums2LeftMax > nums1RightMin) {
                l = i + 1;
            } else {
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
