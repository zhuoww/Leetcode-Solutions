class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int k = left + (right - left) / 2;//// Get the middle index between left and right boundary indexes
            int minHours = 0;// the total hour Koko spends
            for (int pile : piles) {
                minHours += Math.ceil((double) pile / k);
            }

            if (minHours <= h) {// minimize the speed
                right = k;// k may be the answer here, cannot be skipped, so it's not k - 1
            } else {// current eating speed is too slow to finish within the given hours
                left = k + 1;// k must not be the answer
            }
        }
        return right;

    }
}