/*medium-> 求背包是否正好装满
    time:O(N * S)： N is the number of elements in the input array nums. S is the sum of all elements in nums
    space:O(S)：S is the sum of all elements in nums
 * 1. dp[j]表示 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]
 * 2. 递推公式：dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]), 此题价值和重量一样
 * 3. 初始化：dp[0] = 0; 其他值初始化为最小的非负整数，不影响后面取最大值
 * 4. 遍历顺序：先物品，再背包，背包倒序
 */

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

}