/*
 * easy
 */

//greedy: time:O(n),space:O(1)
class Solution {
    public int buyChoco(int[] prices, int money) {
        int res = money;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < first) {
                second = first;
                first = prices[i];
            } else if (prices[i] < second) {
                second = prices[i];
            }
        }

        int leftover = res - first - second;
        return leftover >= 0 ? leftover : res;
    }
}

// Sorting: time:O(nlogn),space:O(1)
class Solution {
    public int buyChoco(int[] prices, int money) {
        int res = money;
        Arrays.sort(prices);
        int sum = prices[0] + prices[1];

        return res < sum ? res : res - sum;
    }
}