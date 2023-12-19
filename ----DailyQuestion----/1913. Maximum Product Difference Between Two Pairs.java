/*
 * easy
 */

//sorting: time:O(nlogn); space:O(1)
class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        return (nums[len - 1] * nums[len - 2] - nums[0] * nums[1]);
    }
}

// time:O(n);space:O(1)
class Solution {
    public int maxProductDifference(int[] nums) {
        int firstBig = 0;
        int secondBig = 0;
        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > firstBig) {
                secondBig = firstBig;
                firstBig = num;
            } else if (num > secondBig) {
                secondBig = num;
            }

            if (num < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = num;
            } else if (num < secondSmall) {
                secondSmall = num;
            }
        }

        return (firstBig * secondBig - firstSmall * secondSmall);

    }
}