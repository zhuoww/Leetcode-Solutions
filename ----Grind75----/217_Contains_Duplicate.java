import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        HashSet<Integer> set = new HashSet<>();

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
