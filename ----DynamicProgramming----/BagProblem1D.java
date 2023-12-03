/*一维dp数组，即滚动数组
1.dp[j]:容量为j的背包，所背的物品价值可以最大为dp[j]
2.递推公式： dp[j] = max(dp[j], dp[j - weight[i]] + value[i])
3.初始化：dp[0] = 0;
4.遍历顺序：必须先遍历item，再遍历bag，bag必须倒序遍历
    1.如果先遍历背包，那么每个dp[j]只放一个物品
    2.倒序遍历的原因是，本质上还是一个对二维数组的遍历，并且右下角的值依赖上一层左上角的值，
    因此需要保证左边的值仍然是上一层的，从右向左覆盖。
*/

public class BagProblem1D {
    public static void testBagProblem(int[] weight, int[] value, int bagSize) {
        // dp[j]表示背包容量为j时，能获得的最大价值
        int len = weight.length;
        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < len; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int j = 0; j <= bagSize; j++) {
            System.out.println(dp[j] + "\t");
        }
    }

    public static void main(String[] args) {
        int[] weight = { 1, 3, 4 };
        int[] value = { 15, 20, 30 };
        int bagSize = 4;
        testBagProblem(weight, value, bagSize);

    }
}
