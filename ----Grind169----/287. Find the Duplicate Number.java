/*
 * medium
 * 
 */

//Floyd's Cycle Detection (Fast-Slow Pointers): Treat the array as a linked list to find a cycle
//time:O(n);space:O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// bit
// time:O(nlogn);space:O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] ^ nums[i + 1]) == 0)
                return nums[i];
        }
        return -1;
    }
}
