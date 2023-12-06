//easy
//time: O(1); space:O(1)

class Solution {
    public int totalMoney(int n) {
        int w = n / 7; // complete weeks
        int extra = n % 7; // extra days

        int total = w * 28 + 7 * w * (w - 1) / 2;
        int curMonday = w + 1;
        for (int i = 0; i < extra; i++) {
            total += curMonday;
            curMonday++;
        }

        return total;
    }
}

/*
 * week1: [1,2,3,4,5,6,7] -> 28
 * week2: [2,3,4,5,6,7,8] -> 28 + 7
 * week3: [3,4,5,6,7,8,9] -> 28 + 7 + 7
 * week4: [4,5,6] -> monday = week3 + 1;
 */
