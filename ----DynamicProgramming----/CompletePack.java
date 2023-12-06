/*完全背包，与01背包的区别：每件物品有无限个，即体现遍历顺序不一样
背包正序遍历，物品可添加多次
完全背包中，一维dp的两个for循环顺序可颠倒，背包正序
01背包中，一维dp只能先遍历物品，再遍历背包，背包倒序； 二维dp中，两个for循环顺序可颠倒
*/

//先物品，再背包
public class CompletePack {
    public static void test(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        dp[0] = 0;

        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagSize; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int v : dp) {
            System.out.println(v + " ");
        }
    }

    public static void main(String[] args) {
        int[] weight = { 1, 3, 4 };
        int[] value = { 15, 20, 30 };
        int bagSize = 4;

        test(weight, value, bagSize);
    }

}

// //先背包，再物品

// public class CompletePack {
// public static void test(int[] weight, int[] value, int bagSize) {
// int[] dp = new int[bagSize + 1];
// dp[0] = 0;

// for (int j = 1; j <= bagSize; j++) {
// for (int i = 0; i < weight.length; i++) {
// if (j - weight[i] >= 0) {
// dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
// }

// }
// }

// for (int v : dp) {
// System.out.println(v + " ");
// }
// }

// public static void main(String[] args) {
// int[] weight = { 1, 3, 4 };
// int[] value = { 15, 20, 30 };
// int bagSize = 4;

// test(weight, value, bagSize);
// }

// }
