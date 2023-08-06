//hashset
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums == null || nums.length < 2)
            return false;

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}

// sorting
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
