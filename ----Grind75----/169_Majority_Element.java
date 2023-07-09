//Boyer-Moore Majority Voting Algorithm: time: O(n), space: O(1), run time: 1ms
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int majority = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}

//// Boyer-Moore Majority Voting Algorithm: time: O(n), space: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int majority = nums[0];
        int count = 0;

        for (int num : nums) {
            if (num == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = num;
                    count++;
                }
            }
        }
        return majority;
    }
}

// HashMap: run time: 17 ms, time and space complexity: O(n)
// key少，使用map快
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}

// sorting: time: O(nlogn), space: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
