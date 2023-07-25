import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];// store the cheapest prices for reaching each city
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;// the cost to reach the source city is 0

        for (int i = 0; i < k + 1; i++) {// k stops means running k + 1 times
            int[] temp = new int[n];
            temp = Arrays.copyOf(prices, prices.length);// ensures that calculations for subsequent flights are based on
                                                        // the original prices

            for (int j = 0; j < flights.length; j++) {
                int s = flights[j][0];
                int d = flights[j][1];
                int p = flights[j][2];

                if (prices[s] == Integer.MAX_VALUE)
                    continue;// means that the source city is not reachable yet, so we skip this flight
                if (prices[s] + p < temp[d]) {
                    temp[d] = prices[s] + p;
                }
            }
            prices = temp;
        }
        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1; // if prices[dst] == Integer.MAX_VALUE, means that
                                                                    // the destination city is not reachable

    }
}
