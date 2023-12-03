/*二维dp数组
1.dp[i][j]: 从下标0-i的物品里任意取放进容量为j的背包，价值总和最大是多少
2.递推公式：dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
    1.不放item i： dp[i][j] = dp[i - 1][j]
    2.放item i： dp[i][j] = dp[i - 1][j - weight[i]] + value[i]
3.初始化：
    1.背包容量为0时，无法放入物品：dp[i][0] = 0;
    2.j<weight[i]时，物品i无法放入背包：dp[0][j] = 0;
    3.j>=weight[i]时，物品i可放入背包：dp[0][j] = value[0];
4.遍历顺序：先遍历物品或先遍历背包都可以
    dp[i-1][j]和dp[i - 1][j - weight[i]] 都在dp[i][j]的左上角方向（包括正上方向），所以先遍历谁都可以
*/

public class BagProblem2D {
    public static void testBagProblem(int[] weight, int[] value, int bagSize) {
        // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
        int len = weight.length;// the number of items
        int[][] dp = new int[len][bagSize + 1];

        // initialize
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // fill out dp array, 二维背包问题，先遍历物品或先遍历背包都可以，因为值都是由正上方和左上方推导而来的
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    /*
                     * When the capacity of the current bag is not as large as the
                     * current item i, item i will not be placed
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * The current bag capacity can hold items i
                     * 1.not include item i; 2. include item i;
                     * Compare these two situations
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // print
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.println(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[] weight = { 1, 3, 4 };
        int[] value = { 15, 20, 30 };
        int bagSize = 4;
        testBagProblem(weight, value, bagSize);
    }
}
