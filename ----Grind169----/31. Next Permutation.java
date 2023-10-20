class Solution {
    // time: O(n); space: O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return;

        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    // [6, 2, 1, 5, 4, 3, 0]
    // i j
    // [6, 2, 3, 5, 4, 1, 0]
    // i+1 n-1
    // [6, 2, 3, 0, 1, 4, 5]

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}