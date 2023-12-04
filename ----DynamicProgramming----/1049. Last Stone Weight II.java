/*
 * medium->求背包最多能装多少
 * time:O(N * S)： N is the number of elements in the input array stones. S is the sum of all elements in stones
    space:O(S)：S is the sum of all elements in stones
    1. dp[j]表示 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]
    2. 递推公式：dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]), 此题价值和重量一样
    3. 初始化：dp[0] = 0; 其他值初始化为最小的非负整数，不影响后面取最大值
    4. 遍历顺序：先物品，再背包，背包倒序
 */

class Solution {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0)
            return 0;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
