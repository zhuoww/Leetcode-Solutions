//prefix and suffix
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0)
            return res;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= suffix;
            suffix *= nums[j];
        }

        return res;
    }
}

// division
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        if (zeroCount > 1) {
            return res;
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    res[i] = product;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = product / nums[i];
            }
        }

        return res;

    }
}

// follow up - space: O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int product = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                nums[i] = product / nums[i];
            } else if (zeroCount == 1) {
                nums[i] = nums[i] != 0 ? 0 : product;
            } else {
                nums[i] = 0;
            }
        }
        return nums;
    }
}

// brute force
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
                res[i] = product;
            }
        }
        return res;

    }
}